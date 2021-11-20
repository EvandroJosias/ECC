import clDBconn


## comando que apaga a tela
print("\x1b[2J\x1b[1;1H")

print("Iniciando o programa")

db = clDBconn.DBConn("teste.db")

tabela = { 'table': 'casal', 'fields':  {  'id' : 'integer', 'name' : 'varchar[30]' } }

##db.create_struct( tabela )

db.check_struct( tabela )


print("Fim de programa")