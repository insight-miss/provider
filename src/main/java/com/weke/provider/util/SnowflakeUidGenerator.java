package com.weke.provider.util;


import org.springframework.stereotype.Component;

@Component
public class SnowflakeUidGenerator implements UidGenerator{

    private SnowFlake snowFlake = new SnowFlake(getMachineId(), 3);


    @Override
    public long nextId() {
        return snowFlake.nextId();
    }

    @Override
    public String nextIdstr() {
        return String.valueOf(nextId());
    }

    protected long getMachineId() {
        // 获得机器码

        return 2;
    }
}
