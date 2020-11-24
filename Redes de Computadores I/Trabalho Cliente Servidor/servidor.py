import socket

HOST = 'localhost'
PORT = 99995

#SOCK_STREAM = TCP / SOCK_DGRAM = UDP
s = socket(AF_INET, SOCK_STREAM)
#Atribui o host a uma porta específica
s.bind((HOST, PORT))
#Quantos clientes o servidor pode conectar
s.listen(1)

#Loop de recebimento de mensagens
while True:
    con, adr = s.accept()
    #Tamanho permitido de mensagem 1024bytes
    msg = con.recv(1024)
    #Decodifica a mensagem de bytes para algo legível
    print(msg = msg.decode())