# Chatter

    zookeeper-server-start /opt/homebrew/etc/kafka/zookeeper.properties
    kafka-server-start /opt/homebrew/etc/kafka/server.properties
brew services start kafka
Or, if you don't want/need a background service you can just run:
/opt/homebrew/opt/kafka/bin/kafka-server-start /opt/homebrew/etc/kafka/server.properties