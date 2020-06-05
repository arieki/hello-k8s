FROM adoptopenjdk/openjdk11
RUN addgroup --system spring && adduser --system --ingroup spring spring
USER spring:spring
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","id.talentia.hellok8s.HelloK8sApplication"]    