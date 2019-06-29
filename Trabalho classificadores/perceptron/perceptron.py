import numpy as np
import matplotlib.pyplot as plt
import pandas as pd


class Perceptron():
    ''' 
    Configurações do Perceptron:

    learningRate -> taxa de atualizacao de pesos
    minErroClassificacao -> minimo erro de classificacao
    bolsoAccuracy -> melhor acuracia encontrada
    bolso -> pesos da melhor acuracia encontrada
    '''
    dataset = pd.read_csv('house-votes.csv')
    Xf = dataset.iloc[:, 1:].values
    Yf = dataset.iloc[:, 0].values
    learningRate = 0.01
    plotData = []
    pesos = np.random.rand(16, 1)
    minErroClassificacao = 1000
    bolsoAccuracy = 0
    bolso = []


    def particionaDataset(self, arrayY):
        for i in range(0, len(self.dataset)):
            if arrayY[i] == 'democrat':
                arrayY[i] = -1

            elif arrayY[i] == 'republican':
                arrayY[i] = 1

        arrayY = arrayY.astype(int)


    def selecionaVotos(self, arrayX):
        for linha in range(0, len(self.dataset)):
            for coluna in range(0, 16):
                if 'y' in arrayX[linha][coluna]:
                    arrayX[linha][coluna] = 1.0

                elif 'n' in arrayX[linha][coluna]:
                    arrayX[linha][coluna] = -1.0

                elif '?' in arrayX[linha][coluna]:
                    arrayX[linha][coluna] = 0.0

    '''
    Predição: multiplicação de matrizes dos votos e seus pesos
    '''
    def predicao(self, votos, pesos):
        predicao = np.dot(votos, pesos)[0][0]
        return predicao


    def atualizar_pesos(self, label, predicao, atualX):
        if label == 1 and predicao < 0:
            self.pesos = self.pesos + self.learningRate * np.transpose(atualX)
        elif label == -1 and predicao > 0:
            self.pesos = self.pesos - self.learningRate * np.transpose(atualX)


    def calcular_erro(self, label, predicao):
        return (label - predicao)**2

    def atualizar_bolso(self, accuracy):
        if accuracy > self.bolsoAccuracy:
            self.bolsoAccuracy = accuracy
            self.bolso = self.pesos
            print("Bolso atualizado, melhor acuracia: {}".format(self.bolsoAccuracy))

    def acuracia(self):
        aux = 0.0
        for i in range(0, len(self.Xf)):
            atualX = self.Xf[i].reshape(-1, self.Xf.shape[1])
            atualY = self.Yf[i]
            result_predicao = self.predicao(atualX, self.pesos)
            if (atualY == 1 and result_predicao > 0) or (atualY == -1 and result_predicao < 0):
                aux += 1
        return aux/len(self.Xf)


if __name__ == "__main__":
    pct = Perceptron()

    pct.particionaDataset(pct.Yf)
    pct.selecionaVotos(pct.Xf)

    '''
    A análise será sempre de um conjunto de 100 elementos aleatórios
    isso significa que a cada execução do algoritmo teremos valores distintos
    pois valores diferentes entrarão no array valores_aleatorios.
    '''
    for iteracao in range(100):
        erroClassificacao = 0
        tamanho_lote = 20
        valores_aleatorios = []

        for i in range(tamanho_lote):
            valores_aleatorios.append(np.random.choice(range(0, len(pct.Xf))))

        for i in valores_aleatorios:
            atualX = pct.Xf[i].reshape(-1, pct.Xf.shape[1])
            atualY = pct.Yf[i]
            result_predicao = pct.predicao(atualX, pct.pesos)

            pct.atualizar_pesos(atualY, result_predicao, atualX)

            erroClassificacao = erroClassificacao + pct.calcular_erro(atualY, result_predicao)

        acc = pct.acuracia()
        pct.atualizar_bolso(acc)

        pct.plotData.append(erroClassificacao)
        if erroClassificacao < pct.minErroClassificacao:
            pct.minErroClassificacao = erroClassificacao

    print("Acuraria do bolso: ", pct.bolsoAccuracy)
    print("Pesos do bolso:", pct.bolso)
    plt.plot(np.arange(0, 100), pct.plotData)
    plt.xlabel("Numero de interacoes")
    plt.ylabel("Numero de Erro de classificacao")
    plt.show()
