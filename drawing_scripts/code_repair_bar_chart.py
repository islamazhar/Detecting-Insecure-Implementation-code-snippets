import numpy as np
import matplotlib.pyplot as plt
plt.style.use('ggplot')

countries = [1, 2, 3, 4, 5, 6, 7, 8]
bronzes = np.array([85, 38,69, 19, 24, 12, 24, 10])
silvers = np.array([225, 173, 219, 68, 40, 90,68,20])
ind = [x for x, _ in enumerate(countries)]


plt.barh(ind, silvers, height=0.8, label='Failure', color='red', edgecolor='black')
plt.barh(ind, bronzes, height=0.8, label='Success', color='green', edgecolor='black')

#plt.xticks(ind, countries)
plt.xlabel("# of code snippets")
plt.ylabel("Rule #")
plt.legend(loc="upper right")
plt.title("Number of code snippets repaired successfully")
plt.grid(True)
plt.yticks(ind, countries)
plt.legend() 
for i, v in enumerate(bronzes):
    plt.text(silvers[i]+2, i , str( (bronzes[i] * 100//silvers[i])) + '%', color='black')
plt.show()

#import tikzplotlib
#tikzplotlib.save("test.tex")


