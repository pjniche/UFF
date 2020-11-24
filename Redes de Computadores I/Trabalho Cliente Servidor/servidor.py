from socket import *

HOST = 'localhost'
PORT = 55555

print(HOST, PORT)

#SOCK_STREAM = TCP / SOCK_DGRAM = UDP
s = socket(AF_INET, SOCK_STREAM)
#Atribui o host a uma porta específica
s.bind((HOST, PORT))
#Quantos clientes o servidor pode conectar
s.listen(5)

#Loop de recebimento de mensagens
while True:
    con, adr = s.accept()
    while True:
        #Tamanho permitido de mensagem 1024bytes
        msg = con.recv(1024)
        #Decodifica a mensagem de bytes para algo legível
        print("Mensagem recebida: ", msg.decode())