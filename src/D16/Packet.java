package D16;

import java.util.Arrays;

public class Packet {
    private String packet;
    private int version, id;
    private Packet[] subPackets;
    private Long value;
    private int packetLength;

    public Packet(String packet, boolean isMainPacket) {
        this.packet = packet;
        version = Integer.parseInt(packet.substring(0, 3), 2);
        id = Integer.parseInt(packet.substring(3, 6), 2);
        if (id == 4) {
            decodeValue();
        } else {
            decodeSubPackets();
            calculateValueFromSubPackets();
        }
        while (isMainPacket && packetLength < packet.length() && packet.charAt(packetLength) == '0') {
            packetLength++;
        }
    }

    private void calculateValueFromSubPackets() {
        switch (id) {
            case 0:
                sum();
                break;
            case 1:
                product();
                break;
            case 2:
                value = Arrays.stream(subPackets).mapToLong(Packet::getValue).min().getAsLong();
                break;
            case 3:
                value = Arrays.stream(subPackets).mapToLong(Packet::getValue).max().getAsLong();
                break;
            case 5:
                value = subPackets[0].getValue() > subPackets[1].getValue() ? 1L : 0L;
                break;
            case 6:
                value = subPackets[0].getValue() < subPackets[1].getValue() ? 1L : 0L;
                break;
            case 7:
                value = subPackets[0].getValue().equals(subPackets[1].getValue()) ? 1L : 0L;
                break;
        }
    }

    private void product() {
        value = 1L;
        for (Packet subPacket : subPackets) {
            value *= subPacket.getValue();
        }
    }

    private void sum() {
        value = 0L;
        for (Packet subPacket : subPackets) {
            value += subPacket.getValue();
        }
    }

    private void decodeSubPackets() {
        int packetIndex = 6;
        boolean Ibit = packet.charAt(packetIndex) == '1';
        packetIndex++;

        if (Ibit) {
            int numberOfSubPackets = Integer.parseInt(packet.substring(packetIndex, packetIndex + 11), 2);
            subPackets = new Packet[numberOfSubPackets];
            packetIndex += 11;
            for (int i = 0; i < numberOfSubPackets; i++) {
                subPackets[i] = new Packet(packet.substring(packetIndex), false);
                packetIndex += subPackets[i].getPacketLength();
            }
        } else {
            int expectedLengthOfSubPackets = Integer.parseInt(packet.substring(packetIndex, packetIndex + 15), 2);
            int currentLengthOfSubPackets = 0;
            subPackets = new Packet[0];
            packetIndex += 15;
            while (currentLengthOfSubPackets < expectedLengthOfSubPackets) {
                subPackets = Arrays.copyOf(subPackets, subPackets.length + 1);
                subPackets[subPackets.length - 1] = new Packet(packet.substring(packetIndex), false);
                currentLengthOfSubPackets += subPackets[subPackets.length - 1].getPacketLength();
                packetIndex += subPackets[subPackets.length - 1].getPacketLength();
            }
        }
        packetLength = packetIndex;
    }

    private void decodeValue() {
        int i = 6;
        char isContinue;
        String binary;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            isContinue = packet.charAt(i);
            binary = packet.substring(i + 1, i + 5);
            i += 5;
            stringBuilder.append(binary);
        } while (isContinue == '1');
        value = Long.parseLong(stringBuilder.toString(), 2);
        packetLength = i;
    }

    public int getPacketLength() {
        return packetLength;
    }

    @Override
    public String toString() {
        return "version=" + version +
                ", id=" + id +
                ", value=" + value;
    }

    public int VersionSum() {
        int res = version;
        if (subPackets != null) {
            for (Packet subPacket : subPackets) {
                res += subPacket.VersionSum();
            }
        }
        return res;
    }

    public Long getValue() {
        return value;
    }
}
