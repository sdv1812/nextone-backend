#!/bin/bash
export AWS_S3_BUCKET=nextone-dev
export AWS_REGION=ap-southeast-2
export MONGO_URI='mongodb+srv://nextonedb-cluster.uxcq4.mongodb.net/nextoneDb?retryWrites=true&w=majority&appName=nextonedb-cluster'
export MONGO_USER=admin
export MONGO_PASSWORD=admin

nest start --watch