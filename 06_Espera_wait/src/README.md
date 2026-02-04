# M09-RA2
## 1. Per què s'atura l'execució al cap d'un temps?
Se detiene porque todos los hilos terminan esperando a que alguien cancele su reserva. Como las acciones de reservar y cancelar son aleatorias, llega un momento en el que todos los hilos se quedan bloqueados en estado de espera (wait()), esperando a que otro hilo libere una plaza.
## Què passaria si en lloc de una probabilitat de 50%-50% fora de 70%(ferReserva)-30%(cancel·lar) I si foren al revés les probabilitats? -> Mostra la porció de codi modificada i la sortida resultant en cada un dels 2 casos.

### Caso A: 70% Reserva / 30% Cancelar:
 El evento se llenará muy rápido. Habrá muchos hilos en estado de espera (wait()) y el programa se bloqueará casi de inmediato porque la tasa de liberación es muy baja.

<img width="650" height="875" alt="caso1" src="https://github.com/user-attachments/assets/66167d1e-bcd8-48fb-8ec5-9409f87aac7c" />

 ### Caso B: 30% Reserva / 70% Cancelar:
  El evento estará casi siempre vacío. Los hilos casi nunca entrarán en wait(), y verás muchos mensajes de "no ha pogut cancel·lar una reserva inexistent".
<img width="694" height="973" alt="caso2" src="https://github.com/user-attachments/assets/ab5ea994-7763-4827-9a81-bce84476ccb1" />


  ## 3. Per què creus que fa falta la llista i no valdria només amb una variable sencera de reserves?
  La lista es esencial para la validación de identidad. Si usáramos solo un entero (int reserves), cualquier hilo podría llamar a cancelaReserva y aumentar el número de plazas disponibles, incluso si ese hilo no tenía una reserva previa. La lista permite verificar con assistents.contains(a) si el hilo realmente tiene permiso para liberar una plaza.
