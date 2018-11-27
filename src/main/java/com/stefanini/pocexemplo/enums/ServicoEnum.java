package com.stefanini.pocexemplo.enums;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonDeserialize(using = ServicoEnum.ServicoEnumDeserializer.class)
public enum ServicoEnum {

	TRANSFERENCIA("Transferência"), PAGAMENTO("Pagamento");

	private String descricao;

	private ServicoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getChave() {
		return this.name();
	}

	public String getDescricao() {
		return descricao;
	}

	public static class ServicoEnumDeserializer extends StdDeserializer<ServicoEnum> {
		private static final long serialVersionUID = 1L;

		public ServicoEnumDeserializer() {
			super(ServicoEnum.class);
		}

		@Override
		public ServicoEnum deserialize(JsonParser jp, DeserializationContext dc)
				throws IOException, JsonProcessingException {
			final JsonNode jsonNode = jp.readValueAsTree();
			String chave = jsonNode.get("chave").asText();
			String descricao = jsonNode.get("descricao").asText();

			for (ServicoEnum servico : ServicoEnum.values()) {
				if (servico.getChave().equals(chave) && servico.getDescricao().equals(descricao)) {
					return servico;
				}
			}
			throw dc.mappingException("Problema para deserializar ServicoEnum - chave: " + chave + " valor: " + descricao);
		}
	}
}
