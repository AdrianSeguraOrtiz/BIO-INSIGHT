## NAME

Evaluate Generic Prediction

## AUTHOR

Adrián Segura Ortiz

## DESCRIPTION

This component is responsible for assessing the accuracy with which any generic network has been predicted with respect to a given gold standard. To do so, it approaches the case as a binary classification problem between 0 and 1.

# DOCKER

## Build

```
docker build -t eagrn-inference/evaluate/generic_prediction -f components/evaluate/generic_prediction/Dockerfile .
```

## Run

```
docker run -v $(pwd)/tmp:/usr/local/src/tmp/ eagrn-inference/evaluate/generic_prediction inferred_networks/dream4_010_01_exp/ea_consensus/final_network.csv input_data/DREAM4/GS/dream4_010_01_gs.csv
```