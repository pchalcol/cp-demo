# Kafka exemples

## Pour utiliser ce projet
1. Démarrer avec docker-compose le projet `cp-demo`, disponible [ici](https://github.com/confluentinc/cp-demo).
Un certain nombre de prérequis sont nécessaires avant de pouvoir le lancer, il faut donc lire le README du projet.
La version de la documentation qui vous intéresse est [ici](https://docs.confluent.io/5.1.1/tutorials/cp-demo/docs/index.html)

2. Il y a deux parties dans ce projet:
- Executions standalone (package `com.github.pchalcol.wikiedit.standalone`).
Les classes `StandaloneProducer` et `StandaloneConsumer` illustrent les configs des producteurs et consommateurs.
- Execution `pipeline` (package `com.github.pchalcol.wikiedit.standalone`).
La classe `Main` démarre une topologie simple avec un topic kafka source, un topic kafka sink et une base de données sink.
 
