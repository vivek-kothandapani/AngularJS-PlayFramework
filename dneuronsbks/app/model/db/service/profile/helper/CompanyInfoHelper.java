package model.db.service.profile.helper;

import model.db.bean.profile.AccountInfo;
import model.db.bean.profile.Address;
import model.db.bean.profile.LegalInfo;
import model.db.bean.profile.ProfileInfo;
import common.Constants;
import controllers.beans.CompanyInfoVo;

public class CompanyInfoHelper {

	private static Address address = null;

	public static Address getAddressInstance() {

		if (address == null) {
			address = new Address();
		}
		return address;
	}

	public boolean createCompanyInfo(
			controllers.beans.CompanyInfoVo companyInfos) {

		AccountInfo accountInfo = AccountInfo.finder.byId(companyInfos
				.getAccountId());
		if (accountInfo == null) {
			return false;
		}

		String addressId = accountInfo.getAddressId();

		Address address = null;
		if (addressId != null) {
			address = Address.finder.byId(Integer.valueOf(accountInfo
					.getAddressId()));
		} else {
			address = new Address();
		}
		accountInfo.setStatus(Constants.ACNT_STATUS_NEW_1);
		accountInfo.setCompanyName(companyInfos.getCompanyName());
		address.setCity(companyInfos.getCity());
		address.setAddress1(companyInfos.getCompanyAddress1());
		address.setAddress2(companyInfos.getCompanyAddress2());
		address.setCountry(companyInfos.getCountry());
		address.setPhone1(companyInfos.getPhoneNumber());
		address.setPostalCode(companyInfos.getPostalCode());
		address.setStateProvince(companyInfos.getProvince());
		address.setEmail1(companyInfos.getEmail());
		
		address.setContactPersonName1(companyInfos.getCompanyName());
		
		address.save("profile");
		accountInfo.setAddressId(String.valueOf(address.getAddressId()));
		accountInfo.save("profile");

		return true;
	}

	public boolean acceptTerms(controllers.beans.CompanyInfoVo companyInfos) {
		AccountInfo accountInfo = AccountInfo.finder.byId(companyInfos
				.getAccountId());
		String legalInfoId = accountInfo.getLegalInfoId();
		LegalInfo legalInfo = null;
		if (legalInfoId == null) {
			legalInfo = new LegalInfo();
		} else {
			legalInfo = LegalInfo.finder.byId(Integer.parseInt(legalInfoId));
		}

		legalInfo.setTermsAgreed(companyInfos.getTermsAgreed());
		legalInfo.save("profile");
		return true;
	}

	public boolean createMoreCompanyInfo(
			controllers.beans.CompanyInfoVo companyInfos) {

		AccountInfo accountInfo = AccountInfo.finder.byId(companyInfos
				.getAccountId());
		String addressId = accountInfo.getAddressId();
		String profileInfoId = accountInfo.getProfileInfoId();
		String legalInfoId = accountInfo.getLegalInfoId();
		ProfileInfo profileInfo = null;
		LegalInfo legalInfo = null;
		Address address = null;
		if (profileInfoId == null) {
			profileInfo = new ProfileInfo();
		} else {
			profileInfo = ProfileInfo.finder.byId(Integer
					.parseInt(profileInfoId));
		}
		if (legalInfoId == null) {
			legalInfo = new LegalInfo();
		} else {
			legalInfo = LegalInfo.finder.byId(Integer.parseInt(legalInfoId));
		}

		if (addressId == null) {
			address = new Address();
		} else {
			address = Address.finder.byId(Integer.parseInt(addressId));
		}

		accountInfo.setStatus(Constants.ACNT_STATUS_NEW_2);

		Address legalAddress = null;

		String legalAddressId = legalInfo.getLegealAddressId();

		if (legalAddressId == null) {
			legalAddress = new Address();
		}
		else
		{
			legalAddress = Address.finder.byId(Integer.parseInt(legalAddressId));
		}

		legalAddress.setCity(companyInfos.getLegalCity());
		legalAddress.setAddress1(companyInfos.getLegalCompanyAddress1());
		legalAddress.setAddress2(companyInfos.getLegalCompanyAddress2());
		legalAddress.setCountry(companyInfos.getLegalCountry());
		legalAddress.setPostalCode(companyInfos.getLegalPostaCode());
		legalAddress.setStateProvince(companyInfos.getLegalProvince());
		legalAddress.setPhone1("Empty");
		legalAddress.setEmail1("Empty");
		legalAddress.setContactPersonName1("Empty");

		legalAddress.save("profile");

		profileInfo.setCompanyType(companyInfos.getCompanyType());
		profileInfo.setWhatWeSell(companyInfos.getWhatWeSell());
		profileInfo.setYourIndustry(companyInfos.getIndustry());
		legalInfo.setCompanyName(companyInfos.getLegalCompanyName());
		profileInfo.save("profile");
		legalInfo
				.setLegealAddressId(String.valueOf(legalAddress.getAddressId()));
		legalInfo.save("profile");
		accountInfo.setLegalInfoId(String.valueOf(legalInfo.getLegalInfoId()));
		accountInfo
				.setProfileInfoId((String.valueOf(profileInfo.getProfileId())));
		accountInfo.save("profile");
		return true;
	}

	public CompanyInfoVo isTermsAgreed(Integer accountId) {
		CompanyInfoVo companyInfoVo = new CompanyInfoVo();
		String legalInfoId = AccountInfo.finder.byId(accountId)
				.getLegalInfoId();
		Integer legal_info = 0;
		if (legalInfoId != null) {
			legal_info = Integer.valueOf(legalInfoId);
		}
		LegalInfo legal = LegalInfo.finder.byId(legal_info);
		if (legal != null) {
			companyInfoVo.setTermsAgreed(legal.getTermsAgreed());
		}
		return companyInfoVo;
	}

	public CompanyInfoVo getMoreCompanyInfo(Integer accountId) {
		CompanyInfoVo companyInfoVo = new CompanyInfoVo();
		Integer address_Id = 0;
		Integer profile_Id = 0;
		Integer legal_info = 0;

		String profileId = AccountInfo.finder.byId(accountId)
				.getProfileInfoId();
		String legalInfoId = AccountInfo.finder.byId(accountId)
				.getLegalInfoId();

		if (profileId != null) {
			profile_Id = Integer.valueOf(profileId);
		}
		if (legalInfoId != null) {
			legal_info = Integer.valueOf(legalInfoId);
		}

		ProfileInfo profile = ProfileInfo.finder.byId(profile_Id);
		LegalInfo legal = LegalInfo.finder.byId(legal_info);

		String addressId = null;

		if (legal != null) {
			addressId = legal.getLegealAddressId();
		}

		if (addressId != null) {
			address_Id = Integer.valueOf(addressId);
		}
		Address address = Address.finder.byId(address_Id);

		if (address != null) {
			companyInfoVo.setLegalCity(address.getCity());
			companyInfoVo.setLegalCompanyName(legal.getCompanyName());
			companyInfoVo.setLegalCompanyAddress1(address.getAddress1());
			companyInfoVo.setLegalCompanyAddress2(address.getAddress2());
			companyInfoVo.setLegalProvince(address.getStateProvince());
			companyInfoVo.setLegalPostaCode(address.getPostalCode());
			companyInfoVo.setPhoneNumber(address.getPhone1());
			companyInfoVo.setLegalCountry(address.getCountry());

		}
		if (profile != null) {
			companyInfoVo.setCompanyType(profile.getCompanyType());
			companyInfoVo.setWhatWeSell(profile.getWhatWeSell());
			companyInfoVo.setIndustry(profile.getYourIndustry());
		}
		if (legal != null) {
			companyInfoVo.setLegalCompanyName(legal.getCompanyName());
		}

		return companyInfoVo;

	}

	public CompanyInfoVo getCompanyInfo(Integer accountId) {
		CompanyInfoVo companyInfoVo = null;
		AccountInfo accountInfo = AccountInfo.finder.byId(accountId);
		if (accountInfo == null) {
			return companyInfoVo;
		}

		String addressId = AccountInfo.finder.byId(accountId).getAddressId();

		if (addressId != null) {
			Address address = Address.finder.byId(Integer.valueOf(addressId));
			if (address != null) {

				companyInfoVo = new CompanyInfoVo();
				companyInfoVo.setCity(address.getCity());
				companyInfoVo.setCompanyName(accountInfo.getCompanyName());
				companyInfoVo.setCompanyAddress1(address.getAddress1());
				companyInfoVo.setCompanyAddress2(address.getAddress2());
				companyInfoVo.setProvince(address.getStateProvince());
				companyInfoVo.setPostalCode(address.getPostalCode());
				companyInfoVo.setPhoneNumber(address.getPhone1());
				companyInfoVo.setCountry(address.getCountry());
				companyInfoVo.setEmail(address.getEmail1());

			}
		}

		return companyInfoVo;

	}

}
