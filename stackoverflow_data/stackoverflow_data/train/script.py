import pandas as pd

file_name = "answer_snippets.annotations.csv"
data = pd.read_csv(file_name, 'r')
print(data.headers())