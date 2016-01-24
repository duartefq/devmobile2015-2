#!/bin/sh
branch="04-cadastramentocnatifrn-app"

echo "Pushing to $branch"
git push origin master:$branch
echo "Done"