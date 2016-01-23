#!/bin/sh
branch="05-cadastramentocnatifrn-app"

echo "Pushing to $branch"
git push origin master:$branch
echo "Done"