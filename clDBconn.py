# Import Section
import sqlite3
import io


class DBConn:
    def __init__( self, databasename = ':memory:' ) -> None:
        print("Criou o banco : ", databasename )
        self.__conn = sqlite3.connect( databasename )        

    def __del__(self) -> None:
        self.__conn.commit()
        print("entrou no destructor")

    def check_struct(self, dictionary):
        for key in dictionary:
            print(key)
