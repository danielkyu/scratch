FROM openjdk:17 as builder

# Needed to install `xargs` which is used by the gradle
RUN microdnf install findutils

FROM builder

CMD ["echo", "OK"]
