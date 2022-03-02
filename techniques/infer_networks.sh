parallel_inference() {
	technique=$1
	in_file=$2
    data_id=$(basename ${in_file%.*})

    out_id="../inferred_networks/$data_id/lists/GRN_$(basename ${technique%.*})"
    Rscript $technique $in_file $out_file $out_id
}
export -f parallel_inference

techniques=$(ls *.R)
files=$(ls ../expression_data/*/EXP/*.csv)

for f in ${files[@]}
do
    data_id=$(basename ${f%.*})
    mkdir -p ../inferred_networks/$data_id/lists
    gene_names=$(cut -f1 -d',' $f | tr -d '"')
    echo ${gene_names[@]} > ../inferred_networks/$data_id/gene_names.txt
done

parallel parallel_inference ::: ${techniques[@]} ::: ${files[@]}

# Añadir llamada de java
# java -cp ./EAGRN-JMetal/target/AEGRN-1.0-SNAPSHOT-jar-with-dependencies.jar SingleNetworkRunner

