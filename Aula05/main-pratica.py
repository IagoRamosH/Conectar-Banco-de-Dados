import requests
requisicao = requests.get("https://economia.com.br/last/USD-BRL,EUR-BRL,BTC-BRL")
print(requisicao)