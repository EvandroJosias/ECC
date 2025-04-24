import clDBconn
## comando que apaga a tela
print("\x1b[2J\x1b[1;1H")

print("Iniciando o programa")

db = clDBconn.DBConn("teste.db")

tabela1 = { 'table': 'casal', 'fields':  {  'id' : 'integer', 'name' : 'varchar[30]' } }
tabela2 = { 'table': 'encontros', 'fields':  {  'id' : 'integer', 'tema' : 'varchar[30]' , 'data' : 'datetime' } }

db.check_struct( tabela1 )
db.check_struct( tabela2 )


print("Fim de programa")