package crypto.blockchain.shopviacrypto.config;

import java.io.Serializable;

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6803651448784053267L;

	public enum UserRoleTypeEnum {
		USER, SUPERUSER, MODERATOR, ADMIN, SUPERADMIN;
	}

	public static UserRoleTypeEnum getUserRoleTypeEnum(int userRoleId) {
		switch (userRoleId) {
		case 2:
			return UserRoleTypeEnum.SUPERUSER;
		case 3:
			return UserRoleTypeEnum.MODERATOR;
		case 4:
			return UserRoleTypeEnum.ADMIN;
		case 5:
			return UserRoleTypeEnum.SUPERADMIN;
		default:
			return UserRoleTypeEnum.USER;
		}
	}

	public static int getUserRoleTypeEnumTypeId(UserRoleTypeEnum roleTypeEnum) {
		switch (roleTypeEnum) {
		case SUPERUSER:
			return 2;
		case MODERATOR:
			return 3;
		case ADMIN:
			return 4;
		case SUPERADMIN:
			return 5;
		default:
			return 1;
		}
	}
	
	
}
