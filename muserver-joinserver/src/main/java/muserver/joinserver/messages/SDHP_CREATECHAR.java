package muserver.joinserver.messages;

import com.google.auto.value.AutoValue;
import muserver.common.AbstractPacket;
import muserver.common.GlobalDefinitions;
import muserver.common.messages.PBMSG_HEAD;
import muserver.utils.EndianUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
typedef struct
{
	PBMSG_HEAD	h;
	int         UserNumber;
	int			DBNumber;
	short		Number;
	char        AccountId[MAX_IDSTRING];
	char		Name[MAX_IDSTRING];
	BYTE		ClassSkin;
} SDHP_CREATECHAR, *LPSDHP_CREATECHAR;
 */
@AutoValue
public abstract class SDHP_CREATECHAR extends AbstractPacket<SDHP_CREATECHAR> {
    public static Builder builder() {
        return new AutoValue_SDHP_CREATECHAR.Builder();
    }

    public static SDHP_CREATECHAR create(PBMSG_HEAD header, Integer userNumber, Integer dbNumber, Short number, String accountId, String name, Byte classSkin) {
        return builder()
                .header(header)
                .userNumber(userNumber)
                .dbNumber(dbNumber)
                .number(number)
                .accountId(accountId)
                .name(name)
                .classSkin(classSkin)
                .build();
    }

    public static SDHP_CREATECHAR deserialize(ByteArrayInputStream stream) throws IOException {
        PBMSG_HEAD header = PBMSG_HEAD.deserialize(stream);

        return SDHP_CREATECHAR.create(
                header,
                EndianUtils.readIntegerLE(stream),
                EndianUtils.readIntegerLE(stream),
                EndianUtils.readShortLE(stream),
                new String(EndianUtils.readBytes(stream, GlobalDefinitions.MAX_IDSTRING)),
                new String(EndianUtils.readBytes(stream, GlobalDefinitions.MAX_IDSTRING)),
                EndianUtils.readByte(stream)
        );
    }

    public abstract PBMSG_HEAD header();

    public abstract Integer userNumber();

    public abstract Integer dbNumber();

    public abstract Short number();

    public abstract String accountId();

    public abstract String name();

    public abstract Byte classSkin();

    @Override
    public byte[] serialize(ByteArrayOutputStream stream) throws IOException {
        header().serialize(stream);
        EndianUtils.writeIntegerLE(stream, userNumber());
        EndianUtils.writeIntegerLE(stream, dbNumber());
        EndianUtils.writeShortLE(stream, number());
        EndianUtils.writeString(stream, accountId(), GlobalDefinitions.MAX_IDSTRING);
        EndianUtils.writeString(stream, name(), GlobalDefinitions.MAX_IDSTRING);
        EndianUtils.writeByte(stream, classSkin());
        return stream.toByteArray();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder header(PBMSG_HEAD header);

        public abstract Builder userNumber(Integer userNumber);

        public abstract Builder dbNumber(Integer dbNumber);

        public abstract Builder number(Short number);

        public abstract Builder accountId(String accountId);

        public abstract Builder name(String name);

        public abstract Builder classSkin(Byte classSkin);

        public abstract SDHP_CREATECHAR build();
    }
}
