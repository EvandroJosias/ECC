
import sqlite3
import io

# conectando...
conn = sqlite3.connect('clientes.db')
# definindo um cursor
cursor = conn.cursor()

# criando a tabela (schema)
cursor.execute("""
CREATE TABLE clientes (
        id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
        nome TEXT NOT NULL,
        idade INTEGER,
        cpf     VARCHAR(11) NOT NULL,
        email TEXT NOT NULL,
        fone TEXT,
        cidade TEXT,
        uf VARCHAR(2) NOT NULL,
        criado_em DATE NOT NULL
);
""")

print('Tabela criada com sucesso.')


# inserindo dados na tabela
cursor.execute("""
INSERT INTO clientes (nome, idade, cpf, email, fone, cidade, uf, criado_em)
VALUES ('Regis', 35, '00000000000', 'regis@email.com', '11-98765-4321', 'Sao Paulo', 'SP', '2014-06-08')
""")

cursor.execute("""
INSERT INTO clientes (nome, idade, cpf, email, fone, cidade, uf, criado_em)
VALUES ('Aloisio', 87, '11111111111', 'aloisio@email.com', '98765-4322', 'Porto Alegre', 'RS', '2014-06-09')
""")

cursor.execute("""
INSERT INTO clientes (nome, idade, cpf, email, fone, cidade, uf, criado_em)
VALUES ('Bruna', 21, '22222222222', 'bruna@email.com', '21-98765-4323', 'Rio de Janeiro', 'RJ', '2014-06-09')
""")

cursor.execute("""
INSERT INTO clientes (nome, idade, cpf, email, fone, cidade, uf, criado_em)
VALUES ('Matheus', 19, '33333333333', 'matheus@email.com', '11-98765-4324', 'Campinas', 'SP', '2014-06-08')
""")

# gravando no bd
conn.commit()

print('Dados inseridos com sucesso.')

# criando uma lista de dados
lista = [(
    'Fabio', 23, '44444444444', 'fabio@email.com', '1234-5678', 'Belo Horizonte', 'MG', '2014-06-09'),
    ('Joao', 21, '55555555555', 'joao@email.com',
     '11-1234-5600', 'Sao Paulo', 'SP', '2014-06-09'),
    ('Xavier', 24, '66666666666', 'xavier@email.com', '12-1234-5601', 'Campinas', 'SP', '2014-06-10')]

# inserindo dados na tabela
cursor.executemany("""
INSERT INTO clientes (nome, idade, cpf, email, fone, cidade, uf, criado_em)
VALUES (?,?,?,?,?,?,?,?)
""", lista)

conn.commit()

print('Dados inseridos com sucesso.')


# solicitando os dados ao usuário
p_nome = input('Nome: ')
p_idade = input('Idade: ')
p_cpf = input('CPF: ')
p_email = input('Email: ')
p_fone = input('Fone: ')
p_cidade = input('Cidade: ')
p_uf = input('UF: ')
p_criado_em = input('Criado em (yyyy-mm-dd): ')

# inserindo dados na tabela
cursor.execute("""
INSERT INTO clientes (nome, idade, cpf, email, fone, cidade, uf, criado_em)
VALUES (?,?,?,?,?,?,?,?)
""", (p_nome, p_idade, p_cpf, p_email, p_fone, p_cidade, p_uf, p_criado_em))

conn.commit()

print('Dados inseridos com sucesso.')


# lendo os dados
cursor.execute("""
SELECT * FROM clientes;
""")

for linha in cursor.fetchall():
    print(linha)


id_cliente = 1
novo_fone = '11-1000-2014'
novo_criado_em = '2014-06-11'

# alterando os dados da tabela
cursor.execute("""
UPDATE clientes
SET fone = ?, criado_em = ?
WHERE id = ?
""", (novo_fone, novo_criado_em, id_cliente))

conn.commit()

print('Dados atualizados com sucesso.')


id_cliente = 8

# excluindo um registro da tabela
cursor.execute("""
DELETE FROM clientes
WHERE id = ?
""", (id_cliente,))

conn.commit()

print('Registro excluido com sucesso.')


# adicionando uma nova coluna na tabela clientes
cursor.execute("""
ALTER TABLE clientes
ADD COLUMN bloqueado BOOLEAN;
""")

conn.commit()

print('Novo campo adicionado com sucesso.')

nome_tabela = 'clientes'

# obtendo informações da tabela
cursor.execute('PRAGMA table_info({})'.format(nome_tabela))

colunas = [tupla[1] for tupla in cursor.fetchall()]
print('Colunas:', colunas)
# ou
# for coluna in colunas:
#    print(coluna)

# listando as tabelas do bd
cursor.execute("""
SELECT name FROM sqlite_master WHERE type='table' ORDER BY name
""")

print('Tabelas:')
for tabela in cursor.fetchall():
    print("%s" % (tabela))

# obtendo o schema da tabela
cursor.execute("""
SELECT sql FROM sqlite_master WHERE type='table' AND name=?
""", (nome_tabela,))

print('Schema:')
for schema in cursor.fetchall():
    print("%s" % (schema))


with io.open('clientes_dump.sql', 'w') as f:
    for linha in conn.iterdump():
        f.write('%s\n' % linha)

print('Backup realizado com sucesso.')
print('Salvo como clientes_dump.sql')


conn = sqlite3.connect('clientes_recuperado.db')
cursor = conn.cursor()

f = io.open('clientes_dump.sql', 'r')
sql = f.read()
cursor.executescript(sql)

print('Banco de dados recuperado com sucesso.')
print('Salvo como clientes_recuperado.db')


# desconectando...
conn.close()
