# Import Section
import sqlite3
import io


class DBConn:
    def __init__( self, databasename = ':memory:' ) -> None:
        print("Criou o banco : ", databasename )
        self.__tables = []
        self.__conn = sqlite3.connect( databasename )        
        self.__cursor = self.__conn.cursor()
        self.__getTables()

    def __del__(self) -> None:
        self.__conn.commit()
        print("entrou no destructor")

    def check_struct(self, dictionary):
        for key in dictionary:
            if key == 'table' :
               self.__getStruct( dictionary[key]) 
            print(key)

    def create_struct(self, dictionary):
        fields = dictionary['fields']
        strSql = 'CREATE TABLE '
        strSql = strSql + dictionary['table'] + " ( "
        for item in fields:
            strSql = strSql + item + " " + fields[ item ] + ", "
            ##print( item," -> ", fields[item], "\n")
            ##for item in fields[ cto ]:
                ##print( item, "\n" )
                ##for key, value in dic.items():
                ##    if value == ite
                ##       listaNova[i].append(key)
        lix = len( strSql )
        strSql = strSql[ 0:lix-2 ] + " )" 
        self.__cursor.execute( strSql )

    def __getTables( self ):
        strSql = "SELECT name FROM sqlite_master WHERE type='table';"
        self.__cursor.execute( strSql )
        colunas = [tupla[0] for tupla in self.__cursor.fetchall()]
        print('Colunas:', colunas)

    def __getStruct( self, tblname ):
        # obtendo informações da tabela
        print("Entrou no __getStruct : ", tblname )
        self.__cursor.execute('PRAGMA table_info({})'.format(tblname))
        colunas = [tupla[1] for tupla in self.__cursor.fetchall()]
        print('Colunas:', colunas)
# ou
# for coluna in colunas:
#    print(coluna)

