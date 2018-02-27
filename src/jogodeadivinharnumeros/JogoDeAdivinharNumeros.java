/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodeadivinharnumeros;


    import java.util.Random;
    import java.util.Scanner;
    import static jogodeadivinharnumeros.JogoDeAdivinharNumeros.Jogar;
/**
 *
 * @author guigr
 */
public class JogoDeAdivinharNumeros {
    
    // metodo para saber se o usuario acertou o numero
    public static void dica(int palpite, int numero, int tentativas){
        if(palpite > numero){
            System.out.println("O meu número é menor. Tente de novo.");
        } else {
            if(palpite < numero){
                    System.out.println("O meu número é maior. Tente de novo");
            } else {
                System.out.println("Parabéns voce acertou meu numero em: " + tentativas + " tentativa(s)!");
                 if(tentativas == 1 ){
                     System.out.println("Que Sorte !!");
                 }  if (tentativas < 11 && tentativas > 1){
                     System.out.println("Muito Bem !!");
                 }  if (tentativas > 10) {
                     System.out.println(" ");
                    } 
              }
                    if (tentativas > 20) {
                    System.out.println("Infelizmente você perdeu! Meu número foi " + numero);
                    }
          }
    }
            
    public static void Jogar(){
        int palpite=0, 
            sorteado, 
            tentativas=0,
            playAgain = 0;
        
        //flag usada para o loop caso o usuario digite uma entrada invalida
        boolean flag = false;
        
        Scanner entrada = new Scanner(System.in);
        
        Random geradorDeAleatorios = new Random();
        sorteado = geradorDeAleatorios.nextInt(250) + 1;
        System.out.println("Número entre 1 e 250 sorteado!");
        
        // laço para o jogo rodar pelo menos uma unica vez
        do{
            System.out.printf("\n\n-----------------\n");
            System.out.println("Número de tentativas: " + tentativas + " de 20");
            
            System.out.print("Qual seu palpite: ");
            
            //laço para o validador de entrada
            do{
            try{
               palpite = Integer.parseInt(entrada.nextLine());
               flag = true;
            }catch(NumberFormatException e){
                System.out.println(" ");
                System.out.println("Por favor, digite apenas números!");
                System.out.println(" ");
                flag = false; // para ter certeza
            } 
            }while(!flag); //enquanto flag for false roda o validador  
            
            
            tentativas++;
            dica(palpite,sorteado, tentativas);
            
        }while (palpite != sorteado && tentativas != 21);
        System.out.println(" ");
        
        //laço para jogar novamente
        do{
        System.out.println("Deseja jogar novamente ?");
        System.out.println("1- Sim ou 2-Nao");
        
         //condição para caso o usuario digitar um comando invalido
            do{
                try{
                    playAgain = Integer.parseInt(entrada.nextLine());
                    flag = true;
                } catch(NumberFormatException e){
                    System.out.println(" ");
                    System.out.println("Por favor, digite apenas números!");
                    System.out.println(" ");
                    flag = false; 
                  } 
            }   while(!flag); //enquanto flag for false roda o validador 
            
        } while(playAgain != 1 && playAgain !=2);
        
            if (playAgain == 1) {
                Jogar();
            } else {
                System.out.println("Obrigado por jogar.");
                System.exit(0);
              }
    }
    
    public static void main(String[] args) {
        Jogar();
    }
}
