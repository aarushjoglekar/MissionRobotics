#!/bin/bash

# Check if a branch name was provided
if [ -z "$1" ]; then
  echo "Usage: $0 <branch-name>"
  exit 1
fi

BRANCH="$1"

# Create a new branch and switch to it
echo "Creating and switching to new branch '$BRANCH'..."
git checkout -b "$BRANCH"

# Push the new branch to the remote
echo "Pushing new branch '$BRANCH' to remote..."
git push -u origin "$BRANCH"

echo "✅ Branch '$BRANCH' created and pushed successfully."