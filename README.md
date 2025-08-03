# Chatter

    /opt/homebrew/opt/kafka/bin/zookeeper-server-start /opt/homebrew/etc/kafka/zookeeper.properties
    /opt/homebrew/opt/kafka/bin/kafka-server-start /opt/homebrew/etc/kafka/server.properties
    /opt/homebrew/bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic chatter-topic --from-beginning
    /opt/homebrew/bin/kafka-console-producer --bootstrap-server localhost:9092 --topic chatter-topic



brew services start kafka
Or, if you don't want/need a background service you can just run:
/opt/homebrew/opt/kafka/bin/kafka-server-start /opt/homebrew/etc/kafka/server.properties

/opt/homebrew/opt/postgresql@14/bin/postgres -D /opt/homebrew/var/postgresql@14
