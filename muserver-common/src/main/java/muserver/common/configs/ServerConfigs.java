package muserver.common.configs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import muserver.common.types.ServerType;

@AutoValue
public abstract class ServerConfigs extends AbstractConfigs {

 public static Builder builder() {
  return new AutoValue_ServerConfigs.Builder();
 }

 @JsonProperty("code")
 public abstract Short code();

 @JsonProperty("name")
 public abstract String name();

 @JsonProperty("address")
 public abstract String address();

 @JsonProperty("port")
 public abstract Integer port();

 @JsonProperty("type")
 public abstract ServerType type();

 @JsonCreator
 public static ServerConfigs create(
         @JsonProperty("code") Short code,
         @JsonProperty("name") String name,
         @JsonProperty("address") String address,
         @JsonProperty("port") Integer port,
         @JsonProperty("type") ServerType type
 ) {
  return builder()
          .code(code)
          .name(name)
          .address(address)
          .port(port)
          .type(type)
          .build();
 }

 @AutoValue.Builder
 public abstract static class Builder {

  public abstract Builder code(Short code);

  public abstract Builder name(String name);

  public abstract Builder address(String address);

  public abstract Builder port(Integer port);

  public abstract Builder type(ServerType type);

  public abstract ServerConfigs build();
 }
}
