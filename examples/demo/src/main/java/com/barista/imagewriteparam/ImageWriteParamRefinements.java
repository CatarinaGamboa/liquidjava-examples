package com.barista.imagewriteparam;

import java.util.Locale;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@StateSet({"tiling_disabled", "tiling_default", "tiling_explicit", "tiling_explicit_with_parameters", "tiling_copy_from_metadata"})
@StateSet({"compression_disabled", "compression_default", "compression_explicit", "compression_copy_from_metadata", "compression_explicit_set"})
@ExternalRefinementsFor("javax.imageio.ImageWriteParam")
public interface ImageWriteParamRefinements {
    
    @StateRefinement(to="tiling_copy_from_metadata(this) && compression_copy_from_metadata(this)")
    public void ImageWriteParam(Locale locale);

    // @StateRefinement(from="", to="")
    // This is always false and is set by the subclasses, so if we want to define state transitions at the subclass level is better.
    // there is some sort of dependency of the superclass by the subclass.
    // public boolean canWriteTiles();

    // @StateRefinement(from="", to="")
    // This is always false and is set by the subclasses, so if we want to define state transitions at the subclass level is better
    // public boolean canOffsetTiles();

    @StateRefinement(to="mode == 0 ? tiling_disabled(this) : (mode == 1 ? tiling_default(this) : (mode == 2 ? tiling_explicit(this) : tiling_copy_from_metadata(this)))")
    public void setTilingMode(@Refinement("0 <= mode && mode <= 3") int mode);

    // @StateRefinement() <- Keeps the same so no need for refinements.
    // public int getTilingMode();

    @StateRefinement(from="tiling_explicit(this)", to="tiling_explicit_with_parameters(this)")
    @StateRefinement(from="tiling_explicit_with_parameters(this)", to="tiling_explicit_with_parameters(this)")
    // The parameters here depend on the class value canWriteTiles
    public void setTiling(
        @Refinement("tileWidth >= 0") int tileWidth, 
        @Refinement("tileHeight >= 0") int tileHeight, 
        int tileGridXOffset, 
        int tileGridYOffset);
    
    @StateRefinement(from="tiling_explicit_with_parameters(this)", to="tiling_explicit(this)")
    @StateRefinement(from="tiling_explicit(this)", to="tiling_explicit(this)")
    public void unsetTiling();

    @StateRefinement(from="tiling_explicit_with_parameters(this)", to="tiling_explicit_with_parameters(this)")
    public int getTileWidth();

    @StateRefinement(from="tiling_explicit_with_parameters(this)", to="tiling_explicit_with_parameters(this)")
    public int getTileHeight();

    @StateRefinement(from="tiling_explicit_with_parameters(this)", to="tiling_explicit_with_parameters(this)")
    public int getTileGridXOffset();

    @StateRefinement(from="tiling_explicit_with_parameters(this)", to="tiling_explicit_with_parameters(this)")
    public int getTileGridYOffset();

    // No transitions needed here
    // public boolean canWriteProgressive();
    public void setProgressiveMode(@Refinement("0 == mode || mode == 1 || mode == 3") int mode);
    // public int getProgressiveMode();

    // No transitions here
    // public boolean canWriteCompressed();
    @StateRefinement(to="mode == 0 ? compression_disabled(this) : (mode == 1 ? compression_default(this) : (mode == 2 ? compression_explicit(this) : compression_copy_from_metadata(this)))")
    public void setCompressionMode(@Refinement("0 <= mode && mode <= 3") int mode);

    @StateRefinement(from="compression_explicit(this)", to="compression_explicit_set(this)")
    public void setCompressionType(String compressionType);
    
    @StateRefinement(from="compression_explicit(this)", to="compression_explicit(this)")
    @StateRefinement(from="compression_explicit_set(this)", to="compression_explicit_set(this)")
    public String getCompressionType();
    
    @StateRefinement(from="compression_explicit_set(this)", to="compression_explicit(this)")
    public void unsetCompression();

    @StateRefinement(from="compression_explicit_set(this)", to="compression_explicit_set(this)")
    public String getLocalizedCompressionTypeName();

    @StateRefinement(from="compression_explicit_set(this)", to="compression_explicit_set(this)")
    public boolean isCompressionLossless();

    @StateRefinement(from="compression_explicit_set(this)", to="compression_explicit_set(this)")
    public void setCompressionQuality(@Refinement("0.0 <= quality && quality <= 1.0") float quality);
    
    @StateRefinement(from="compression_explicit_set(this)", to="compression_explicit_set(this)")
    public float getCompressionQuality();

    @StateRefinement(from="compression_explicit_set(this)", to="compression_explicit_set(this)")
    public float getBitRate(@Refinement("0.0 <= quality && quality <= 1.0") float quality);

    @StateRefinement(from="compression_explicit_set(this)", to="compression_explicit_set(this)")
    public String[] getCompressionQualityDescriptions();

    @StateRefinement(from="compression_explicit_set(this)", to="compression_explicit_set(this)")
    public float[] getCompressionQualityValues();
}
