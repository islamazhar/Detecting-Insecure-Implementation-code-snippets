
import numpy as np
import matplotlib.pyplot as plt
plt.style.use('ggplot')

countries = [1, 2, 3, 4, 5, 6, 7, 8]
silvers = np.array([501, 201, 313, 68, 40, 90,68,20])
bronzes = np.array([85, 38,  16  ,19, 20, 4, 3,12])
yellow = np.array([225, 173, 219, 23, 32, 43,12,14])

ind = [x for x, _ in enumerate(countries)]
ind = np.array(ind)
width = .4  # the width of the bars

#plt.barh(ind-width/2, silvers, height=0.3, label='Failure', color='red', edgecolor='black')
plt.barh(ind-width/2, bronzes, height=0.3, label='Before code repairing',  edgecolor='black', hatch='\\')
#plt.barh(ind+width/2, silvers, height=0.3, color='red', edgecolor='black',)
plt.barh(ind+width/2, yellow, height=0.3, label='After code repairing', edgecolor='black', hatch='//')

#plt.xticks(ind, countries)
plt.xlabel("# of code snippets")
plt.ylabel("Insecure pattern #")
plt.legend(loc="upper right")
plt.title("Number of code snippets repaired successfully")
plt.grid(True)
plt.yticks(ind, countries)
plt.legend() 
for i, v in enumerate(bronzes):
    plt.text(yellow[i]+2, i , str( ((yellow[i] - bronzes[i]) * 100 ) // silvers[i] ) + '%', color='black')
plt.show()

#import tikzplotlib
#tikzplotlib.save("test.tex")


