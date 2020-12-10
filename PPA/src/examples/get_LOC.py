import os
import numpy as np

files = os.listdir("AllCodeSnippets")
#print(files)
LOC_arry = np.zeros([len(files)])

for i, _file in enumerate(files):
   f = open("AllCodeSnippets/"+_file, 'r')
   c = 0
   for l in f:
      c+=1
   #print(i)
   LOC_arry[i] = c
print(LOC_arry)      
print(np.mean(LOC_arry), np.std(LOC_arry))
