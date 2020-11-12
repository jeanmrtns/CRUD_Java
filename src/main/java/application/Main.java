package application;

import crud.ReadFile;
import crud.RemoveSensor;
import crud.UpdateFile;
import crud.WriteInFile;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("CRUD em Java");
        System.out.println("1 - Adicionar novo sensor");
        System.out.println("2 - Visualizar sensores cadastrados");
        System.out.println("3 - Modificar sensor");
        System.out.println("4 - Remover sensor");
        System.out.println("Qual opção deseja? ");

        try {
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    WriteInFile write = new WriteInFile();
                    break;
                case 2:
                    ReadFile read = new ReadFile();
                    break;
                case 3:
                    UpdateFile update = new UpdateFile();
                    break;
                case 4:
                    RemoveSensor remove = new RemoveSensor();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (IOException e) {

        }

    }

}
