import sys
import numpy as np
from sklearn.linear_model import LinearRegression

currentLine = 0
f = 0
n = 0
output = []
data  = []
testNum = 0
testLine = 0
testData = []
for line in sys.stdin:
    if currentLine == 0:       
        f_n = line.split(" ")
        f = int(f_n[0]) # Features
        n = int(f_n[1]) - 1 # Lines
        currentLine+=1
        data = np.zeros(shape=(n + 1,f))
        continue;
    if currentLine - 1 <= n:
        dataString = line.split(" ")
        for x in range(0, f):
            data[(currentLine - 1), x] = float(dataString[x])
        dataStriped = dataString[f].strip()
        output.append(float(dataStriped))
        currentLine+=1
        continue;
    if currentLine - 1 == n +1:
        testNum = int(line)
        testData = np.zeros(shape=(testNum,f))
        currentLine+=1
        continue;
    if (currentLine - n +1) - 2 != testNum: 
        dataString = line.split(" ")
        for x in range(0, f):
            testData[testLine, x] = float(dataString[x])
        testLine+=1
    
    
lineReg = LinearRegression(normalize=True)

lineReg.fit(data, output)

predict = lineReg.predict(testData)

for x in predict:
    print x
