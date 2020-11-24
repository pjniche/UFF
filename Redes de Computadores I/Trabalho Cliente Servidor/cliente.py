from socket import *

HOST = '127.0.0.1'
PORT = 55555

#SOCK_STREAM = TCP / SOCK_DGRAM = UDP
c = socket(AF_INET, SOCK_STREAM)
#Conecta cliente ao servidor
c.connect((HOST, PORT))

#Loop de envio de mensagens
while True:
    #Usuário digita mensagem
    msg = input("Digite: ")
    #Cliente envia mensagem codificada em bytes
    c.send(msg.encode())