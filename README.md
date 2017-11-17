# char-pattern-finder
Dada uma stream, encontre o primeiro caractere Vogal, após uma consoante, onde a mesma é antecessora a uma vogal e que não se repita no resto da stream.
O termino da leitura da stream deve ser garantido através do método hasNext(), ou seja, retorna falso para o termino da leitura da stream.
Voce tera acesso a leitura da stream através dos métodos de interface fornecidos.

Premissas:
Uma chamada para hasNext() ir retornar se a stream ainda contem caracteres para processar.
Uma chamada para getNext() ir retornar o proximo caractere a ser processado na stream.
Não será possível reiniciar o fluxo da leitura da stream.
Não poderá ser utilizado nenhum framework Java, apenas código nativo.

Exemplo:
Input:  aAbBABacafe
Output: e
No exemplo, ‘e’ é o primeiro caractere Vogal da stream que não se repete após a primeira Consoante ‘f’o qual tem uma vogal ‘a’ como antecessora.

Segue o exemplo da interface em Java:
public interface Stream{
    public char getNext();
    public boolean hasNext();
}
public static char firstChar(Stream input) {
}

==========================================================================

Q4 - 

Um deadlock acontece quando duas ou mais tarefas bloqueiam uma à outra permanentemente, sendo que cada uma tem o bloqueio de um recurso que a outra tarefa está tentando bloquear. 
Por exemplo, quando um processo (programa em execução) ou uma thread(sub programa) não consegue dar seqüencia pois está dependendo de um recurso que está bloqueado por outro processo ou thread que também não consegue dar seqüência pois está dependendo de um recurso que está bloqueado pelo primeiro processo ou thread, caracteriza-se um deadlock.

1 - A tarefa T1 depende de um recurso r1;
2 - A tarefa T1 ainda tendo um bloqueio(r1) solicita um segundo recurso(r2);
3 - A tarefa T2 depende de um recurso recurso R2;
4 - A tarefa T2 ainda tendo bloqueio(r2) solicita um bloqueio no recurso R1(que já está chamando a tarefa T1[passo 1]);

Neste caso as duas tarefas estão bloqueantes até que um dos recursos esteja disponível, e nenhum recurso pode ser liberado até que a tarefa continue, iss ocaracteriza o deadlock(dependência mútua de disponibilidade);

==========================================================================

Q5 - 
A diferença na execução de uma Stream para uma ParallelStream é que, a implementação de forma paralela permite que o processamento seja dividido entre os processadores da máquina em execução. Se tratando de um processamento de uma coleção, a divisão entre duas Threads tende a agilizar o processamento de uma grande coleção. Vale lembrar que algumas operações do Stream são single thread, então nem sempre a utilização de Streams paralelas resultará em maior desempenho. Outra questão é que o processamento paralelizado estará ligado diretamente aos núcleos da máquina(nº de cores da CPU).