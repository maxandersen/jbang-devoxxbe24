#!/bin/sh

export JBANG_REPO=/tmp/repo
export JBANG_DIR=/tmp/jbang
/opt/jbang-0.106.3/bin/jbang --verbose export fatjar -O /tmp/fat.jar MyApp.java

/var/lang/bin/java -XX:MaxHeapSize=445645k -javaagent:/var/runtime/lib/Log4jHotPatch.jar=log4jFixerVerbose=false -XX:+UseSerialGC -Xshare:on -XX:SharedArchiveFile=/var/lang/lib/server/runtime.jsa -XX:+TieredCompilation -XX:TieredStopAtLevel=1 --add-opens=java.base/java.io=ALL-UNNAMED -Dorg.crac.Core.Compat=com.amazonaws.services.lambda.crac -Djava.net.preferIPv4Stack=true -classpath /var/runtime/lib/aws-lambda-java-core-1.2.2.jar:/var/runtime/lib/aws-lambda-java-runtime-interface-client-2.3.1.jar:/var/runtime/lib/aws-lambda-java-serialization-1.1.2.jar:/tmp/fat.jar com.amazonaws.services.lambda.runtime.api.client.AWSLambda MyApp

REPORT RequestId: 781da282-b2f9-4f3e-ab24-e8a6f8bf6950	Duration: 197.04 ms	Billed Duration: 198 ms	Memory Size: 512 MB	Max Memory Used: 168 MB	Init Duration: 5775.58 ms