import re
import math
from collections import deque

# x são os exemplos do training set
# y representa os atributos
# label é o rótulo dos atributos
# Node é a estrutura de dados que corresponde ao nó da arvore de decisão
# root é o primeiro nó da arvore de decisão

# Classe da estrutura de dados, "como se fosse uma struct em C"
class Node(object):
	def __init__(self):
		self.value = None
		self.next = None
		self.childs = None

# Classe da árvore de decisão
''' 
    No construtor dessa classe é necessário passar o dataset, os rótulos
    e os atributos para o algoritmo do id3 reconhecer como é o dataset
'''
class DecisionTree(object):
	def __init__(self, sample, attributes, labels):
		self.sample = sample
		self.attributes = attributes
		self.labels = labels
		self.labelCodes = None
		self.labelCodesCount = None
		self.initLabelCodes()
		# print(self.labelCodes)
		self.root = None
		self.entropy = self.getEntropy([x for x in range(len(self.labels))])


    # initLabelCodes() adiciona o cada rótulo num vetor de rótulos
	def initLabelCodes(self):
		self.labelCodes = []
		self.labelCodesCount = []
		for label in self.labels:
			if label not in self.labelCodes:
				self.labelCodes.append(label)
				self.labelCodesCount.append(0)
			self.labelCodesCount[self.labelCodes.index(label)] += 1

    # Coleta o rótulo do dataset baseado no id do atributo
	def getLabelCodeId(self, sampleId):
		return self.labelCodes.index(self.labels[sampleId])

    # Coleta o valor de cada atributo (rótulo)
	def getAttributeValues(self, sampleIds, attributeId):
		vals = []
		for sample_id in sampleIds:
			val = self.sample[sample_id][attributeId]
			if val not in vals:
				vals.append(val)
		# print(vals)
		return vals

    # Calcula a entropia
	def getEntropy(self, sampleIds):
		entropy = 0
		labelCount = [0] * len(self.labelCodes)
		for sid in sampleIds:
			labelCount[self.getLabelCodeId(sid)] += 1
		# print("-ge", labelCount)
		for lv in labelCount:
			# print(lv)
			if lv != 0:
				entropy += -lv/len(sampleIds) * math.log(lv/len(sampleIds), 2)
			else:
				entropy += 0
		return entropy

	def getDominantLabel(self, sampleIds):
		labelCodesCount = [0] * len(self.labelCodes)
		for sid in sampleIds:
			labelCodesCount[self.labelCodes.index(self.labels[sid])] += 1
		return self.labelCodes[labelCodesCount.index(max(labelCodesCount))]

	def getInformationGain(self, sampleIds, attributeId):
		gain = self.getEntropy(sampleIds)
		attributeVals = []
		attributeValsCount = []
		attributeValsIds = []
		for sid in sampleIds:
			val = self.sample[sid][attributeId]
			if val not in attributeVals:
				attributeVals.append(val)
				attributeValsCount.append(0)
				attributeValsIds.append([])
			vid = attributeVals.index(val)
			attributeValsCount[vid] += 1
			attributeValsIds[vid].append(sid)
		# print("-gig", self.attributes[attributeId])
		for vc, vids in zip(attributeValsCount, attributeValsIds):
			# print("-gig", vids)
			gain -= vc/len(sampleIds) * self.getEntropy(vids)
		return gain

	def getAttributeMaxInformationGain(self, sampleIds, attributeIds):
		attributesEntropy = [0] * len(attributeIds)
		for i, attId in zip(range(len(attributeIds)), attributeIds):
			attributesEntropy[i] = self.getInformationGain(sampleIds, attId)
		maxId = attributeIds[attributesEntropy.index(max(attributesEntropy))]
		return self.attributes[maxId], maxId

	def isSingleLabeled(self, sampleIds):
		label = self.labels[sampleIds[0]]
		for sid in sampleIds:
			if self.labels[sid] != label:
				return False
		return True

    # Coleta nome do rótulo
	def getLabel(self, sampleId):
		return self.labels[sampleId]

    # Método responsável por chamar o id3
	def id3(self):
		sampleIds = [x for x in range(len(self.sample))]
		attributeIds = [x for x in range(len(self.attributes))]
		self.root = self.id3Recv(sampleIds, attributeIds, self.root)

    # Função responsável por gerar a árvore de decisão
	def id3Recv(self, sampleIds, attributeIds, root):
		root = Node() # Initialize current root
		if self.isSingleLabeled(sampleIds):
			root.value = self.labels[sampleIds[0]]
			return root
		# print(attributeIds)
		if len(attributeIds) == 0:
			root.value = self.getDominantLabel(sampleIds)
			return root
		bestAttrName, bestAttrId = self.getAttributeMaxInformationGain(
			sampleIds, attributeIds)
		# print(bestAttrName)
		root.value = bestAttrName
		root.childs = []  # Create list of children
		for value in self.getAttributeValues(sampleIds, bestAttrId):
			# print(value)
			child = Node()
			child.value = value
			root.childs.append(child)  # Append new child node to current
									   # root
			childSampleIds = []
			for sid in sampleIds:
				if self.sample[sid][bestAttrId] == value:
					childSampleIds.append(sid)
			if len(childSampleIds) == 0:
				child.next = self.getDominantLabel(sampleIds)
			else:
				# print(bestAttrName, bestAttrId)
				# print(attributeIds)
				if len(attributeIds) > 0 and bestAttrId in attributeIds:
					toRemove = attributeIds.index(bestAttrId)
					attributeIds.pop(toRemove)
				child.next = self.id3Recv(
					childSampleIds, attributeIds, child.next)
		return root

    # Mostra a árvore de decisão no console
	def printTree(self):
		if self.root:
			roots = deque()
			roots.append(self.root)
			while len(roots) > 0:
				root = roots.popleft()
				print(root.value)
				if root.childs:
					for child in root.childs:
						print('({})'.format(child.value))
						roots.append(child.next)
				elif root.next:
					print(root.next)


def test():
	f = open('resources/house-votesV2.csv')
	attributes = f.readline().split(',')
	attributes = attributes[1:len(attributes)-1]
	print(attributes)
	sample = f.readlines()
	f.close()
	for i in range(len(sample)):
		sample[i] = re.sub('\d+,', '', sample[i])
		sample[i] = sample[i].strip().split(',')
	labels = []
	for s in sample:
		labels.append(s.pop())
	# print(sample)
	# print(labels)
	decisionTree = DecisionTree(sample, attributes, labels)
	print("System entropy {}".format(decisionTree.entropy))
	decisionTree.id3()
	decisionTree.printTree()


if __name__ == '__main__':
	test()