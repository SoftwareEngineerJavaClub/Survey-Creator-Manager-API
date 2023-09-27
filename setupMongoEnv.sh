#!/bin/bash

export MONGO_DATABASE=survey_api_db
export MONGO_USER=admin
export MONGO_PASSWORD=admin
export MONGO_CLUSTER=cluster0.13aco9q.mongodb.net

# Optionally, you can print out to confirm
echo "Environment variables set:"
echo "MONGO_DATABASE=$MONGO_DATABASE"
echo "MONGO_USER=$MONGO_USER"
echo "MONGO_PASSWORD=$MONGO_PASSWORD"
echo "MONGO_CLUSTER=$MONGO_CLUSTER"

