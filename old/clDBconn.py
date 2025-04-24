# Import Section
import sqlite3
import io


class DBConn:
    def __init__( self, databasename = ':memory:' ) -> None:
        self.__conn = sqlite3.connect( databasename )        
        self.__cursor = self.__conn.cursor()

    def __del__(self) -> None:
        self.__conn.commit()
        print("entrou no destructor")

    def check_struct(self, dictionary):
        for key in dictionary:
            if key == 'table' :
                if self.ExistTables( dictionary[key] ) == False:
                    self.create_struct( dictionary )
                else:
                    print("fazer o check", dictionary[key] )    

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

    def ExistTables( self, pTbl ):
        strSql = "SELECT name FROM sqlite_master WHERE type='table';"
        self.__cursor.execute( strSql )
        for tupla in self.__cursor.fetchall():
            if tupla[0] == pTbl:
               return True
        return False

    def __getStruct( self, tblname ):
        # obtendo informações da tabela
        print("Entrou no __getStruct : ", tblname )
        self.__cursor.execute('PRAGMA table_info({})'.format(tblname))
        colunas = [tupla[1] for tupla in self.__cursor.fetchall()]
        print('Colunas:', colunas)
# ou
# for coluna in colunas:
#    print(coluna)

