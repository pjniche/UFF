#include <bits/stdc++.h>
using namespace std;

int
main ()
{
  int N, M;			//N funcionarios e M clientes
  int total = 0;
  int vetor[100];
  cin >> N >> M;
  for (int i = 1; i <= N; i++)
    cin >> vetor[i];

  priority_queue < pair < int, int >>fila;
  for (int i = 1; i <= N; i++)
    fila.push (make_pair (0, -i));

  while (M--)
    {
      int c;
      cin >> c;
      int id = -fila.top ().second;
      int l = -fila.top ().first;
      fila.pop ();
      fila.push (make_pair (-(l + vetor[id] * c), -id));
      total = max (total, l + vetor[id] * c);
    }

  printf ("%d\n", total);
}
