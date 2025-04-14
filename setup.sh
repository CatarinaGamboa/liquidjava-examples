#!/bin/bash

# Setup script for LiquidJava development environment
echo "🚀 Starting LiquidJava development environment setup..."

# Install Git LFS if not already installed
if ! command -v git-lfs &> /dev/null; then
    echo "📦 Installing Git LFS..."
    sudo apt-get update && sudo apt-get install -y git-lfs
    git lfs install
else
    echo "✅ Git LFS already installed"
fi

# Pull LFS files
echo "🔄 Pulling Git LFS files..."
git lfs pull

# Check if the VSIX file exists and is valid
if [ -f "./extension/liquid-java-0.0.15.vsix" ]; then
    echo "🔍 VSIX file found, checking integrity..."
    file_size=$(stat -c%s "./extension/liquid-java-0.0.15.vsix")
    if [ "$file_size" -lt 1000 ]; then
        echo "❌ VSIX file appears to be an LFS pointer file (too small)"
    else
        echo "✅ VSIX file appears to be valid ($file_size bytes)"
    fi
else
    echo "❌ VSIX file not found at ./extension/liquid-java-0.0.15.vsix"
fi

# Check for examples directory
if [ -d "./examples/demo/src/" ]; then
    echo "✅ Examples directory found: ./examples/demo/src/"
else
    echo "❌ Examples directory not found at ./examples/demo/src/"
    echo "📁 Available directories:"
    find . -type d -maxdepth 2 | sort
fi

echo "🎉 Setup complete! Please follow these manual steps:"
echo "1. Install the extension: View → Extensions → ... → Install from VSIX → extension/liquid-java-0.0.15.vsix"
echo "2. Open examples: File → Open Folder → examples/demo/src/"