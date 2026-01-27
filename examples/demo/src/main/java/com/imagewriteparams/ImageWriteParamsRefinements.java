package com.imagewriteparams;

import java.util.Locale;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@StateSet({"startTiling", "tilingExplicit", "tilingSet"})
@StateSet({"startCompression", "compressionExplicit", "compressionSet"})
@ExternalRefinementsFor("javax.imageio.ImageWriteParam")
public interface ImageWriteParamsRefinements {

    // Constructor
    @StateRefinement(to="startTiling(this) && startCompression(this)")
    void ImageWriteParam(Locale locale);


    // tiling
    @StateRefinement(from="startTiling(this) && mode == 2", to = "tilingExplicit(this)")
    @StateRefinement(from="startTiling(this) && mode != 2", to = "startTiling(this)")
    void setTilingMode(@Refinement("_ >= 0 && _ <= 3") int mode);

    @StateRefinement(from="tilingExplicit(this)", to="tilingSet(this)")
    void setTiling(@Refinement("_ > 0")int tileWidth, @Refinement("_ > 0") int tileHeight, int tileGridXOffset, int tileGridYOffset);
    
    @StateRefinement(from="tilingSet(this)")
    int getTileGridXOffset();
    @StateRefinement(from="tilingSet(this)")
    int getTileGridYOffset();
    @StateRefinement(from="tilingSet(this)")
    int getTileHeight();
    @StateRefinement(from="tilingSet(this)")
    int getTileWidth();
    @StateRefinement(from="tilingExplicit(this)")
    @StateRefinement(from="tilingSet(this)", to="tilingExplicit(this)")
    void unsetTiling();


    // Compression
    @StateRefinement(from="startCompression(this) && mode == 2", to = "compressionExplicit(this)")
    @StateRefinement(from="startCompression(this) && mode != 2", to = "startCompression(this)")   
    void setCompressionMode( int mode);

    @StateRefinement(from="compressionExplicit(this)")
    @StateRefinement(from="compressionSet(this)")  
    void setCompressionQuality(@Refinement("_ >= 0 && _ <=1") float quality);

    @StateRefinement(from="compressionExplicit(this)")   
    @StateRefinement(from="compressionSet(this)")   
    String getCompressionType();

    @StateRefinement(from="compressionExplicit(this)", to="compressionSet(this)")
    void setCompressionType(String compressionType);
   
    @StateRefinement(from="compressionExplicit(this)")   
    @StateRefinement(from="compressionSet(this)", to="compressionExplicit(this)")  
    void unsetCompression();

    @StateRefinement(from="compressionSet(this)")  
    String getLocalizedCompressionTypeName();

    @StateRefinement(from="compressionExplicit(this)")   
    @StateRefinement(from="compressionSet(this)")  
    boolean isCompressionLossless();

    @StateRefinement(from="compressionExplicit(this)")   
    @StateRefinement(from="compressionSet(this)")      
    float getCompressionQuality();

    @StateRefinement(from="compressionExplicit(this)")   
    @StateRefinement(from="compressionSet(this)")      
    float getBitRate(@Refinement("_ >= 0 && _ <= 1") float quality);

    @StateRefinement(from="compressionExplicit(this)")   
    @StateRefinement(from="compressionSet(this)")      
    String[] getCompressionQualityDescriptions();

    @StateRefinement(from="compressionExplicit(this)")   
    @StateRefinement(from="compressionSet(this)")      
    float[] getCompressionQualityValues();


    void setProgressiveMode(@Refinement("_ == 0 || _ == 1 || _ == 3") int mode);


    // boolean canOffsetTiles();
    // boolean canWriteCompressed(); 
    // boolean canWriteProgressive(); //any 
    // boolean canWriteTiles();
    // int getCompressionMode();
    // String[] getCompressionTypes();
    // Locale getLocale();
    // Dimension[] getPreferredTileSizes();
    // int getTilingMode(); // any
    // int getProgressiveMode();



}