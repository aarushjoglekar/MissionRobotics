#!/bin/bash

# Check if a branch name was provided
if [ -z "$1" ]; then
  echo "Usage: $0 <branch-name>"
  exit 1
fi

BRANCH="$1"

git pull

# Switch to the given branch
echo "Switching to branch '$BRANCH'..."
git switch "$BRANCH"

# If the switch was successful, pull the latest changes
if [ $? -eq 0 ]; then
  echo "Pulling latest changes from remote..."
  git pull
else
  echo "Failed to switch to branch '$BRANCH'."
  exit 1
fi

echo "✅ Done."
