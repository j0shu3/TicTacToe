# TicTacToebyOJ

TicTacToebyOJ is a Java program that follows the basic rules of the known game Tic Tae Toe.

## Installation

Use the following link [pip](https://github.com/j0shu3/TicTacToe/raw/master/TicTacToebyOJ.jar) download and execute as JAR by command line.

```bash
java -jar TicTacToebyOJ.jar
```

## Main logic

```java
for (int i = 0; i < numberOfElements; i++) {
           try {
               System.out.println("--------------");
               player = player == 1 ? 0:1;
               System.out.println("Turn: "+ i + " - Player: " + getPlayer(player));
               int randomIndex = rand.nextInt(square.size());
               String randomElement = square.get(randomIndex);
               setState(randomElement, player);
               markOnMatrix(randomElement, player);
               square.remove(randomIndex);
               System.out.println("--------------");
               printMatrix();
               TimeUnit.SECONDS.sleep(2);
               if(hasPlayerWon()) {
                   playerWon = true;
                   break;
               }    
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           
       }

if(playerWon)
           System.out.println("Player " + getPlayer(player) + " wins ");
       else
       System.out.println("Nobody wins");
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.


## License
[MIT](https://choosealicense.com/licenses/mit/)
