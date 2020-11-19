#!/usr/bin/env python3

import socket

HOST = 'localhost'
PORT = 50000

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST, PORT))
s.listen()

print('Aguardando conexão com um cliente')
conn, ender = s.accept()

print('Conectado em', ender)