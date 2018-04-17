FROM arm32v7/ubuntu 
ENV TZ=Asia/Shanghai

MAINTAINER yfxiaodou <yfxiaodou@163.com>

RUN ln -sv /lib/ld-linux-armhf.so.3 /lib/ld-linux.so.3
RUN rm /bin/sh && ln -s /bin/bash /bin/sh 
COPY thunder /app/
COPY start.sh /app/
VOLUME /app/TDDOWNLOAD
RUN chmod +x /app/portal
RUN chmod +x /app/portal && chmod +x /app/start.sh
CMD [ "/app/start.sh" ]
