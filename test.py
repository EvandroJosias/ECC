import clDBconn


## comando que apaga a tela
print("\x1b[2J\x1b[1;1H")

print("Iniciando o programa")

db = clDBconn.DBConn()

tabela = { 'table': 'casal', 'fields':  {  'id' : 'int', 'name' : 'varchar' } }

db.check_struct( tabela )


print("Fim de programa")