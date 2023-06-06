package fieb.aula.confeitaria.api;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSqlSever {

    public static Connection conectar(Context context) {
        //Objeto de conexao
        Connection conn = null;
        try {
//            Adicionar Política de criacao de thread
            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

          /* new Thread(new Runnable() {
               @Override
               public void run() {

               }
           }).start();*/


//        Verificar se o driver de Conexao está importada no projeto
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            //Obtenha o IP de seu computador e insira abaixo
            /*conn= DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.x.x;"+
                    "databaseName=bdConfeitaria;user=sa;password=xxxxx;");
*/
            //Conexão de Teste
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://rastreamento.mssql.somee.com;" +
                    "databaseName=rastreamento;user=HenriqueDiniz_SQLLogin_1;password=ydsqdeflz5;");


        } catch (android.database.SQLException e) { // SQLException
            e.getMessage();
            Toast.makeText(context, "Servidor Indisponível", Toast.LENGTH_LONG).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
