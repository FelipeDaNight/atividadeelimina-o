import java.util.*;

public class Atvpessoas {

    static class Person {
        String name; // nome da pessoa
        String cpf; // CPF da pessoa
        String phone; // telefone da pessoa
        String address; // endereço da pessoa

        public Person(String name, String cpf, String phone, String address) {
            this.name = name;
            this.cpf = cpf;
            this.phone = phone;
            this.address = address;
        }
    }

    static class Josephus {
        List<Person> people; // lista de pessoas
        int m; // número de pessoas a serem eliminadas a cada vez

        public Josephus(List<Person> people, int m) {
            this.people = people;
            this.m = m;
        }

        public void eliminate() {
            Random random = new Random();
            int i = 0;
            while (people.size() > 1) {
                i = (i + random.nextInt(m)) % people.size();
                Person eliminated = people.remove(i);
                System.out.println("Eliminada a pessoa " + eliminated.name + " (CPF: " + eliminated.cpf + ")");
            }
            System.out.println("A pessoa sobrevivente é " + people.get(0).name + " (CPF: " + people.get(0).cpf + ")");
        }
    }

    public static void main(String[] args) {
        int n = 20; // número de pessoas na lista
        int m = 3; // número de pessoas a serem eliminadas a cada vez

        // Criando a lista de pessoas com nomes e CPFs aleatórios
        List<Person> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Person person = new Person(
                "Pessoa " + i, // nome aleatório
                String.format("%011d", i), // CPF sequencial com 11 dígitos
                "(" + (100 + i) + ") " + (10000 + i) + "-" + (1000 + i), // telefone aleatório
                "Rua " + (char)('A' + i - 2) + ", " + (100 + i) // endereço aleatório
            );
            people.add(person);
        }

        // Criando o objeto Josephus e eliminando pessoas com total aleatoriedade
        Josephus josephus = new Josephus(people, m);
        josephus.eliminate();
    }
}
