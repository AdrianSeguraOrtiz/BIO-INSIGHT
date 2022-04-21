## NAME

DREAM4

## AUTHOR

Adrián Segura Ortiz

## DESCRIPTION

This component is responsible for downloading differential expression data and gold standards from DREAM4 challenge.

# DOCKER

## Build

```
docker build -t eagrn-inference/extract_data/dream4/expgs -f components/extract_data/DREAM4/EXPGS/Dockerfile .
```

## Run

```
docker run -v $(pwd)/input_data:/usr/local/src/input_data/ eagrn-inference/extract_data/dream4/expgs ExpressionData input_data
```
