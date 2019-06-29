import csv
import random
import math
from matplotlib import pyplot as plt

#Carrega os dados
def loadCsv(_file):
	lines = csv.reader(open(_file, "r"))
	data = list(lines)
	for i in range(len(data)):
		data[i] = [float(x) for x in data[i]]
	return data

#Separa os dados de treinamento dos testes
def trainingData(data,percentage):
	sample = int(len(data)*percentage)
	Trainingdata = []
	test = list(data)
	while len(Trainingdata)< sample:
		index = random.randrange(len(test))
		Trainingdata.append(test.pop(index))
	return(Trainingdata, test)

#Separa os dados de treinamento em classes
def porClase(data):
	dataClass = {}
	for i in range(len(data)):
		vector = data[i]
		if (vector[-1] not in dataClass):
			dataClass[vector[-1]] = []
		dataClass[vector[-1]].append(vector)
	return dataClass
#Calcula o necessário para saber a probabilitye
def mean(feature):
	return sum(feature)/float(len(feature))

def stdev(feature):
	avg = mean(feature)
	variance = sum([pow(x-avg,2) for x in feature])/float(len(feature)-1)
	return math.sqrt(variance)

#Cria uma lista com a média e o desvio, recebendo os dados de treinamento
def element(Training):
	elements = [(mean(atribute), stdev(atribute)) for atribute in zip(*Training)]
	del elements[-1]
	return elements

def elementByClass(data):
	dataenClase = porClase(data)
	summaries = {}
	for clase, feature in dataenClase.iteritems():
		summaries[clase] = element(feature)
	return summaries

def probability(x,mean,stdev):
	exponent = math.exp(-(math.pow(x-mean,2)/(2*math.pow(stdev,2))))
	return (1/(math.sqrt(2*math.pi)*stdev)) * exponent

def probabilityPerClass(summaries, training_Data):
	probabilityes = {}
	for classValue, ClassSummaries in summaries.iteritems():
		probabilityes[classValue] = 1
		for i in range(len(ClassSummaries)):
			mean, stdev = ClassSummaries[i]
			x = training_Data[i]
			probabilityes[classValue] *=probability(x,mean,stdev)
	return probabilityes

def predict(summaries, training_Data):
	probabilityes = probabilityPerClass(summaries, training_Data)
	return probabilityes

def getPredict(summaries, test):
	predictions = []
	for i in range(len(test)):
		result = predict(summaries, test[i])
		predictions.append(result)
	return predictions

def decide(probabilityes):
	assign = []
	for i in probabilityes:
		if i[0]>i[1]:
			assign.append(0)
		else:
			assign.append(1)
	return assign

def perfomance(decisions,test):
	c = 0 
	for i in range(len(test)):
		if float(decisions[i]) == test[i][-1]:
			c = c+1
	return c/float(len(test))

def main():
	filename = 'dataset.csv'
	data = loadCsv(filename)
	percentage = [0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9]
	result = []
	for i in percentage:
		Training, test = trainingData(data,i)
		summaries = elementByClass(Training)
		probabilityes = getPredict(summaries, test)
		decisions = decide(probabilityes)
		result = perfomance(decisions,test)
		result.append(result)

	plt.plot(percentage, result, color='green', marker='o', linestyle='solid')
	plt.show()
	#print test[1]
	#prueba = [[1.0, 85.0, 66.0, 29.0, 0.0, 26.6, 0.351, 31.0, 0.0],[2.0, 197.0, 70.0, 45.0, 543.0, 30.5, 0.158, 53.0, 1.0]]
	

main()
