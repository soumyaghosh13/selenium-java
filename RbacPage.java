package com.HRA.pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import com.HRA.helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRA.or.RbacOR;


public class RbacPage{

    WebDriver driver = Driver.getDriver();

    public RbacPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);

    LimitedUserPage limitedUserPage = new LimitedUserPage(driver);
    @FindBy(xpath = RbacOR.mpEditPermi)
    public WebElement mpEditPermi;

    @FindBy(xpath = RbacOR.mpUserRoleYes)
    public WebElement mpUserRoleYes;
    @FindBy(xpath = RbacOR.mpUserRoleNo)
    public WebElement mpUserRoleNo;
    @FindBy(xpath = RbacOR.mpGrpAccessAll)
    public WebElement mpGrpAccessAll;
    @FindBy(xpath = RbacOR.mpGrpAccessLmt)
    public WebElement mpGrpAccessLmt;
    @FindBy(xpath = RbacOR.mpViewDetGrpLmt)
    public WebElement mpViewDetGrpLmt;
    @FindBy(xpath = RbacOR.mpViewDetLocLmt)
    public WebElement mpViewDetLocLmt;
    @FindBy(xpath = RbacOR.mpLocAccessAll)
    public WebElement mpLocAccessAll;
    @FindBy(xpath = RbacOR.mpLocAccessLmt)
    public WebElement mpLocAccessLmt;
    @FindBy(xpath = RbacOR.mpGrpOnlyAccess)
    public WebElement mpGrpOnlyAccess;
    @FindBy(xpath = RbacOR.mpGrpExceptAccess)
    public WebElement mpGrpExceptAccess;
    @FindBy(xpath = RbacOR.mpSelectGrp)
    public WebElement mpSelectGrp;
    @FindBy(xpath = RbacOR.mpGrpNoChild)
    public WebElement mpGrpNoChild;
    @FindBy(xpath = RbacOR.mpGrpHasChild)
    public WebElement mpGrpHasChild;
    @FindBy(xpath = RbacOR.mpGrpSave)
    public WebElement mpGrpSave;
    @FindBy(xpath = RbacOR.mpGrpClearAll)
    public WebElement mpGrpClearAll;
    @FindBy(xpath = RbacOR.mpLocOnly)
    public WebElement mpLocOnly;
    @FindBy(xpath = RbacOR.mpLocExcept)
    public WebElement mpLocExcept;
    @FindBy(xpath = RbacOR.mpSelectLoc)
    public WebElement mpSelectLoc;
    @FindBy(xpath = RbacOR.mpLocNoChild)
    public WebElement mpLocNoChild;
    @FindBy(xpath = RbacOR.mpLocHasChild)
    public WebElement mpLocHasChild;
    @FindBy(xpath = RbacOR.mpLocSave)
    public WebElement mpLocSave;
    @FindBy(xpath = RbacOR.mpLocClearAll)
    public WebElement mpLocClearAll;
    @FindBy(xpath = RbacOR.qvMpGrpPerm)
    public WebElement qvMpGrpPerm;
    @FindBy(xpath = RbacOR.qvMpLocPerm)
    public WebElement qvMpLocPerm;
    @FindBy(xpath = RbacOR.qvLmtOtherPerms)
    public WebElement qvLmtOtherPerms;

    // Role is a Limited user
    @FindBy(xpath = RbacOR.limitedRoleYes)
    public WebElement limitedRoleYes;
    @FindBy(xpath = RbacOR.limitedRoleNo)
    public WebElement limitedRoleNo;
    @FindBy(xpath = RbacOR.lmtProfileAdminYes)
    public WebElement lmtProfileAdminYes;
    @FindBy(xpath = RbacOR.lmtProfileAdminNo)
    public WebElement lmtProfileAdminNo;
    @FindBy(xpath = RbacOR.lmtPAGrpAccessAll)
    public WebElement lmtPAGrpAccessAll;
    @FindBy(xpath = RbacOR.lmtPAGrpAccessLmt)
    public WebElement lmtPAGrpAccessLmt;
    @FindBy(xpath = RbacOR.lmtPAGrpAccessViewDet)
    public WebElement lmtPAGrpAccessViewDet;
    @FindBy(xpath = RbacOR.lmtPAGrpOnly)
    public WebElement lmtPAGrpOnly;
    @FindBy(xpath = RbacOR.lmtPAGrpExcept)
    public WebElement lmtPAGrpExcept;
    @FindBy(xpath = RbacOR.lmtPASelect)
    public WebElement lmtPASelect;
    @FindBy(xpath = RbacOR.lmtPAGrpNoChild)
    public WebElement lmtPAGrpNoChild;
    @FindBy(xpath = RbacOR.lmtPAGrpHasChild)
    public WebElement lmtPAGrpHasChild;
    @FindBy(xpath = RbacOR.lmtPAGrpChildren)
    public WebElement lmtPAGrpChildren;
    @FindBy(xpath = RbacOR.lmtPAGrpSelected)
    public WebElement lmtPAGrpSelected;
    @FindBy(xpath = RbacOR.lmtPAGrpPermSave)
    public WebElement lmtPAGrpPermSave;
    @FindBy(xpath = RbacOR.lmtPALocAccessAll)
    public WebElement lmtPALocAccessAll;
    @FindBy(xpath = RbacOR.lmtPALocAccessLmt)
    public WebElement lmtPALocAccessLmt;
    @FindBy(xpath = RbacOR.lmtPALocAccessViewDet)
    public WebElement lmtPALocAccessViewDet;
    @FindBy(xpath = RbacOR.lmtPALocOnly)
    public WebElement lmtPALocOnly;
    @FindBy(xpath = RbacOR.lmtPALocExcept)
    public WebElement lmtPALocExcept;
    @FindBy(xpath = RbacOR.lmtPALocSelect)
    public WebElement lmtPALocSelect;
    @FindBy(xpath = RbacOR.lmtPALocNoChild)
    public WebElement lmtPALocNoChild;
    @FindBy(xpath = RbacOR.lmtPALocpHasChild)
    public WebElement lmtPALocpHasChild;
    @FindBy(xpath = RbacOR.lmtPALocChildren)
    public WebElement lmtPALocChildren;
    // @FindBy(xpath = RbacOR.lmtPALocSelected) public WebElement

    // lmtPALocSelected;
    @FindBy(xpath = RbacOR.lmtConfigAdminYes)
    public WebElement lmtConfigAdminYes;
    @FindBy(xpath = RbacOR.lmtConfigAdminNo)
    public WebElement lmtConfigAdminNo;
    @FindBy(xpath = RbacOR.lmtDataInteAdminYes)
    public WebElement lmtDataInteAdminYes;
    @FindBy(xpath = RbacOR.lmtDataInteAdminNo)
    public WebElement lmtDataInteAdminNo;
    @FindBy(xpath = RbacOR.lmtPAGrpClearAll)
    public WebElement lmtPAGrpClearAll;
    @FindBy(xpath = RbacOR.lmtPALocClearAll)
    public WebElement lmtPALocClearAll;
    @FindBy(xpath = RbacOR.lmtPALocPermSave)
    public WebElement lmtPALocPermSave;

    @FindBy(xpath = RbacOR.qvLmtPAGrpPerm)
    public WebElement qcLmtPAGrpPerm;
    @FindBy(xpath = RbacOR.qvLmtPALocPerm)
    public WebElement qcLmtPALocPerm;

    // This Role can Enter Cases
    @FindBy(xpath = RbacOR.enterCasesRoleYes)
    public WebElement enterCasesRoleYes;
    @FindBy(xpath = RbacOR.enterCasesRoleNo)
    public WebElement enterCasesRoleNo;
    @FindBy(xpath = RbacOR.enterCaseViewDetails)
    public WebElement enterCaseViewDetails;
    @FindBy(xpath = RbacOR.enterCaseER)
    public WebElement enterCaseER;
    @FindBy(xpath = RbacOR.enterCaseERInvPartyYes)
    public WebElement enterCaseERInvPartyYes;
    @FindBy(xpath = RbacOR.enterCaseERInvPartyNo)
    public WebElement enterCaseERInvPartyNo;
    @FindBy(xpath = RbacOR.enterCaseInv)
    public WebElement enterCaseInv;
    @FindBy(xpath = RbacOR.enterCaseInvIntakeOnly)
    public WebElement enterCaseInvIntakeOnly;
    @FindBy(xpath = RbacOR.enterCaseInvInvTeam)
    public WebElement enterCaseInvInvTeam;
    @FindBy(xpath = RbacOR.enterCaseInvLegalAdv)
    public WebElement enterCaseInvLegalAdv;
    @FindBy(xpath = RbacOR.enterCaseEI)
    public WebElement enterCaseEI;
    @FindBy(xpath = RbacOR.enterCasePHInt)
    public WebElement enterCasePHInt;
    @FindBy(xpath = RbacOR.enterCaseSave)
    public WebElement enterCaseSave;
    @FindBy(xpath = RbacOR.enterCaseCancel)
    public WebElement enterCaseCancel;
    @FindBy(xpath = RbacOR.qvEnterCasePerms)
    public WebElement qvEnterCasePerms;

    // This Role can View cases

    @FindBy(xpath = RbacOR.viewCasesYes)
    public WebElement viewCasesYes;
    @FindBy(xpath = RbacOR.viewCasesNo)
    public WebElement viewCasesNo;
    @FindBy(xpath = RbacOR.vcCaseTypeAll)
    public WebElement vcCaseTypeAll;
    @FindBy(xpath = RbacOR.vcCaseTypeLmt)
    public WebElement vcCaseTypeLmt;
    @FindBy(xpath = RbacOR.vcCaseTypeViewDetails)
    public WebElement vcCaseTypeViewDetails;
    @FindBy(xpath = RbacOR.vcCaseTypeER)
    public WebElement vcCaseTypeER;
    @FindBy(xpath = RbacOR.vcCaseTypeINV)
    public WebElement vcCaseTypeINV;
    @FindBy(xpath = RbacOR.vcCaseTypeEI)
    public WebElement vcCaseTypeEI;
    @FindBy(xpath = RbacOR.vcCaseTypePH)
    public WebElement vcCaseTypePH;
    @FindBy(xpath = RbacOR.vcCaseTypeSave)
    public WebElement vcCaseTypeSave;
    @FindBy(xpath = RbacOR.vcGrpAccessLmt)
    public WebElement vcGrpAccessLmt;
    @FindBy(xpath = RbacOR.vcGrpAccessLmtViewDetails)
    public WebElement vcGrpAccessLmtViewDetails;
    @FindBy(xpath = RbacOR.vcGrpAccessAll)
    public WebElement vcGrpAccessAll;
    @FindBy(xpath = RbacOR.vcGrpOnlyAccess)
    public WebElement vcGrpOnlyAccess;
    @FindBy(xpath = RbacOR.vcGrpExceptAccess)
    public WebElement vcGrpExceptAccess;
    @FindBy(xpath = RbacOR.vcGrpAccessclearAll)
    public WebElement vcGrpAccessclearAll;
    @FindBy(xpath = RbacOR.vcSelectGrp)
    public WebElement vcSelectGrp;
    @FindBy(xpath = RbacOR.vcGrpNoChild)
    public WebElement vcGrpNoChild;
    @FindBy(xpath = RbacOR.vcGrpHasChild)
    public WebElement vcGrpHasChild;
    @FindBy(xpath = RbacOR.vcGrpChildren)
    public WebElement vcGrpChildren;
    @FindBy(xpath = RbacOR.vcGrpSelected)
    public WebElement vcGrpSelected;
    @FindBy(xpath = RbacOR.vcGrpSave)
    public WebElement vcGrpSave;
    @FindBy(xpath = RbacOR.vcGrpClearAll)
    public WebElement vcGrpClearAll;
    @FindBy(xpath = RbacOR.vcIssueAccessAll)
    public WebElement vcIssueAccessAll;
    @FindBy(xpath = RbacOR.vcIssueAccessLmt)
    public WebElement vcIssueAccessLmt;
    @FindBy(xpath = RbacOR.vcIssueAccessLmtViewDetails)
    public WebElement vcIssueAccessLmtViewDetails;
    @FindBy(xpath = RbacOR.vcIssuesOnlyAccess)
    public WebElement vcIssuesOnlyAccess;
    @FindBy(xpath = RbacOR.vcIssuesExceptAccess)
    public WebElement vcIssuesExceptAccess;
    @FindBy(xpath = RbacOR.vcSelectIssues)
    public WebElement vcSelectIssues;
    @FindBy(xpath = RbacOR.vcIssueAccessClearAll)
    public WebElement vcIssueAccessClearAll;
    @FindBy(xpath = RbacOR.vcIssuesNoChild)
    public WebElement vcIssuesNoChild;
    @FindBy(xpath = RbacOR.vcIssuesHasChild)
    public WebElement vcIssuesHasChild;
    @FindBy(xpath = RbacOR.vcIssuesChildren)
    public WebElement vcIssuesChildren;
    @FindBy(xpath = RbacOR.vcIssuesSelected)
    public WebElement vcIssuesSelected;
    @FindBy(xpath = RbacOR.vcIssuesSave)
    public WebElement vcIssuesSave;
    @FindBy(xpath = RbacOR.vcLocAccessAll)
    public WebElement vcLocAccessAll;
    @FindBy(xpath = RbacOR.vcLocAccessLmt)
    public WebElement vcLocAccessLmt;
    @FindBy(xpath = RbacOR.vcLocAccessLmtViewDetails)
    public WebElement vcLocAccessLmtViewDetails;
    @FindBy(xpath = RbacOR.vcLocOnlyAccess)
    public WebElement vcLocOnlyAccess;
    @FindBy(xpath = RbacOR.vcLocExceptAccess)
    public WebElement vcLocExceptAccess;
    @FindBy(xpath = RbacOR.vcSelectLoc)
    public WebElement vcSelectLoc;
    @FindBy(xpath = RbacOR.vcLocHasChild)
    public WebElement vcLocHasChild;
    @FindBy(xpath = RbacOR.vcLocNoChild)
    public WebElement vcLocNoChild;
    @FindBy(xpath = RbacOR.vcLocSelected)
    public WebElement vcLocSelected;
    @FindBy(xpath = RbacOR.vcLocSave)
    public WebElement vcLocSave;
    @FindBy(xpath = RbacOR.vcLocClearAll)
    public WebElement vcLocClearAll;
    @FindBy(xpath = RbacOR.qvVcCaseTypePerms)
    public WebElement qvVcCaseTypePerms;
    @FindBy(xpath = RbacOR.qvVcGrpPerm)
    public WebElement qvVcGrpPerm;
    @FindBy(xpath = RbacOR.qvVcIssueAccessPerm)
    public WebElement qvVcIssueAccessPerm;
    @FindBy(xpath = RbacOR.qvVcLocPerm)
    public WebElement qvVcLocPerm;

    // This Role is a case admin
    @FindBy(xpath = RbacOR.caViewCasePermYes)
    public WebElement caViewCasePermYes;
    @FindBy(xpath = RbacOR.caViewCasePermNo)
    public WebElement caViewCasePermNo;
    @FindBy(xpath = RbacOR.caGrpAccessAll)
    public WebElement caGrpAccessAll;
    @FindBy(xpath = RbacOR.caGrpAccessLimited)
    public WebElement caGrpAccessLimited;
    @FindBy(xpath = RbacOR.caGrpAccessLmtViewDetail)
    public WebElement caGrpAccessLmtViewDetail;
    @FindBy(xpath = RbacOR.caGrpOnlyAccess)
    public WebElement caGrpOnlyAccess;
    @FindBy(xpath = RbacOR.caGrpExceptAccess)
    public WebElement caGrpExceptAccess;
    @FindBy(xpath = RbacOR.caSelectGrp)
    public WebElement caSelectGrp;
    @FindBy(xpath = RbacOR.caGrpClearAll)
    public WebElement caGrpClearAll;
    @FindBy(xpath = RbacOR.caGrpNoChild)
    public WebElement caGrpNoChild;
    @FindBy(xpath = RbacOR.caGrpHasChild)
    public WebElement caGrpHasChild;
    @FindBy(xpath = RbacOR.caGrpChildren)
    public WebElement caGrpChildren;
    @FindBy(xpath = RbacOR.caGrpSelected)
    public WebElement caGrpSelected;
    @FindBy(xpath = RbacOR.caGrpSave)
    public WebElement caGrpSave;
    @FindBy(xpath = RbacOR.caLocAccessAll)
    public WebElement caLocAccessAll;
    @FindBy(xpath = RbacOR.caLocAccessLimited)
    public WebElement caLocAccessLimited;
    @FindBy(xpath = RbacOR.caLocAccessLmtViewDetail)
    public WebElement caLocAccessLmtViewDetail;
    @FindBy(xpath = RbacOR.caLocOnlyAccess)
    public WebElement caLocOnlyAccess;
    @FindBy(xpath = RbacOR.caLocExceptAccess)
    public WebElement caLocExceptAccess;
    @FindBy(xpath = RbacOR.caSelectLoc)
    public WebElement caSelectLoc;
    @FindBy(xpath = RbacOR.caLocNoChild)
    public WebElement caLocNoChild;
    @FindBy(xpath = RbacOR.caLocHasChild)
    public WebElement caLocHasChild;
    @FindBy(xpath = RbacOR.caLocSelected)
    public WebElement caLocSelected;
    @FindBy(xpath = RbacOR.caLocSave)
    public WebElement caLocSave;
    @FindBy(xpath = RbacOR.caLocClearAll)
    public WebElement caLocClearAll;
    @FindBy(xpath = RbacOR.qvCaGrpPerm)
    public WebElement qvCaGrpPerm;
    @FindBy(xpath = RbacOR.qvCaLocPerm)
    public WebElement qvCaLocPerm;

    // This role is a Profile Admin
    @FindBy(xpath = RbacOR.profileAdminYes)
    public WebElement profileAdminYes;
    @FindBy(xpath = RbacOR.profileAdminNo)
    public WebElement profileAdminNo;
    @FindBy(xpath = RbacOR.paCaseViewYes)
    public WebElement paCaseViewYes;
    @FindBy(xpath = RbacOR.paCaseViewNo)
    public WebElement paCaseViewNo;
    @FindBy(xpath = RbacOR.paGrpAccessAll)
    public WebElement paGrpAccessAll;
    @FindBy(xpath = RbacOR.paGrpAccessLmt)
    public WebElement paGrpAccessLmt;
    @FindBy(xpath = RbacOR.paGrpAccessViewDetail)
    public WebElement paGrpAccessViewDetail;
    @FindBy(xpath = RbacOR.paGrpOnlyAccess)
    public WebElement paGrpOnlyAccess;
    @FindBy(xpath = RbacOR.paGrpExceptAccess)
    public WebElement paGrpExceptAccess;
    @FindBy(xpath = RbacOR.paSelectGrp)
    public WebElement paSelectGrp;
    @FindBy(xpath = RbacOR.paGrpNoChild)
    public WebElement paGrpNoChild;
    @FindBy(xpath = RbacOR.paGrpHasChild)
    public WebElement paGrpHasChild;
    @FindBy(xpath = RbacOR.paGrpChildren)
    public WebElement paGrpChildren;
    @FindBy(xpath = RbacOR.paGrpSelected)
    public WebElement paGrpSelected;
    @FindBy(xpath = RbacOR.paGrpSave)
    public WebElement paGrpSave;
    @FindBy(xpath = RbacOR.paGrpClearAll)
    public WebElement paGrpClearAll;
    @FindBy(xpath = RbacOR.paLocAccessAll)
    public WebElement paLocAccessAll;
    @FindBy(xpath = RbacOR.paLocAccessLmt)
    public WebElement paLocAccessLmt;
    @FindBy(xpath = RbacOR.paLocAccessViewDetail)
    public WebElement paLocAccessViewDetail;
    @FindBy(xpath = RbacOR.paLocSave)
    public WebElement paLocSave;
    @FindBy(xpath = RbacOR.paLocOnlyAccess)
    public WebElement paLocOnlyAccess;
    @FindBy(xpath = RbacOR.paLocExceptAccess)
    public WebElement paLocExceptAccess;
    @FindBy(xpath = RbacOR.paSelectLoc)
    public WebElement paSelectLoc;
    @FindBy(xpath = RbacOR.paLocNoChild)
    public WebElement paLocNoChild;
    @FindBy(xpath = RbacOR.paLocHasChild)
    public WebElement paLocHasChild;
    @FindBy(xpath = RbacOR.paLocClearAll)
    public WebElement paLocClearAll;
    @FindBy(xpath = RbacOR.qvPaGrpPerm)
    public WebElement qvPaGrpPerm;
    @FindBy(xpath = RbacOR.qvPaLocPerm)
    public WebElement qvPaLocPerm;

    // This role can access Insights reporting
    @FindBy(xpath = RbacOR.rptAccessYes)
    public WebElement rptAccessYes;
    @FindBy(xpath = RbacOR.rptAccessNo)
    public WebElement rptAccessNo;
    @FindBy(xpath = RbacOR.rptCaseTypeAll)
    public WebElement rptCaseTypeAll;
    @FindBy(xpath = RbacOR.rptCaseTypeLmt)
    public WebElement rptCaseTypeLmt;
    @FindBy(xpath = RbacOR.rptCaseTypeLmtViewDetail)
    public WebElement rptCaseTypeLmtViewDetail;
    @FindBy(xpath = RbacOR.rptCaseTypeER)
    public WebElement rptCaseTypeER;
    @FindBy(xpath = RbacOR.rptCaseTypeINV)
    public WebElement rptCaseTypeINV;
    @FindBy(xpath = RbacOR.rptCaseTypeEI)
    public WebElement rptCaseTypeEI;
    @FindBy(xpath = RbacOR.rptCaseTypePH)
    public WebElement rptCaseTypePH;
    @FindBy(xpath = RbacOR.rptCaseTypeSave)
    public WebElement rptCaseTypeSave;
    @FindBy(xpath = RbacOR.rptInsightAnltsNo)
    public WebElement rptInsightAnltsNo;
    @FindBy(xpath = RbacOR.rptInsightAnltsYes)
    public WebElement rptInsightAnltsYes;
    @FindBy(xpath = RbacOR.rptInsightDBNo)
    public WebElement rptInsightDBNo;
    @FindBy(xpath = RbacOR.rptInsightDBYes)
    public WebElement rptInsightDBYes;
    @FindBy(xpath = RbacOR.rptInsightBMYes)
    public WebElement rptInsightBMYes;
    @FindBy(xpath = RbacOR.rptInsightBMNo)
    public WebElement rptInsightBMNo;
    @FindBy(xpath = RbacOR.rptInvPrtDtlsYes)
    public WebElement rptInvPrtDtlsYes;
    @FindBy(xpath = RbacOR.rptCusProFldsYes)
    public WebElement rptCusProFldsYes;
    @FindBy(xpath = RbacOR.rptInvPrtDtlsNo)
    public WebElement rptInvPrtDtlsNo;
    @FindBy(xpath = RbacOR.OK)
    public WebElement OK;
    @FindBy(xpath = RbacOR.rptEvntBsdInstYes)
    public WebElement rptEvntBsdInstYes;
    @FindBy(xpath = RbacOR.rptEvntBsdInstNo)
    public WebElement rptEvntBsdInstNo;
    @FindBy(xpath = RbacOR.rptCaseViewAccessYes)
    public WebElement rptCaseViewAccessYes;
    @FindBy(xpath = RbacOR.rptCaseViewAccessNo)
    public WebElement rptCaseViewAccessNo;
    @FindBy(xpath = RbacOR.rptGrpAccessAll)
    public WebElement rptGrpAccessAll;
    @FindBy(xpath = RbacOR.rptGrpAccessLmt)
    public WebElement rptGrpAccessLmt;
    @FindBy(xpath = RbacOR.rptGrpAccessViewDet)
    public WebElement rptGrpAccessViewDet;
    @FindBy(xpath = RbacOR.rptGrpOnlyAccess)
    public WebElement rptGrpOnlyAccess;
    @FindBy(xpath = RbacOR.rptGrpExceptAccess)
    public WebElement rptGrpExceptAccess;
    @FindBy(xpath = RbacOR.rptSelectGrp)
    public WebElement rptSelectGrp;
    @FindBy(xpath = RbacOR.rptGrpNoChild)
    public WebElement rptGrpNoChild;
    @FindBy(xpath = RbacOR.rptGrpHasChild)
    public WebElement rptGrpHasChild;
    @FindBy(xpath = RbacOR.rptGrpChildren)
    public WebElement rptGrpChildren;
    @FindBy(xpath = RbacOR.rptGrpSelected)
    public WebElement rptGrpSelected;
    @FindBy(xpath = RbacOR.rptGrpClearAll)
    public WebElement rptGrpClearAll;
    @FindBy(xpath = RbacOR.rptGrpSave)
    public WebElement rptGrpSave;
    @FindBy(xpath = RbacOR.rptIssueAccessAll)
    public WebElement rptIssueAccessAll;
    @FindBy(xpath = RbacOR.rptIssueAccessLmt)
    public WebElement rptIssueAccessLmt;
    @FindBy(xpath = RbacOR.rptIssueAccessViewDet)
    public WebElement rptIssueAccessViewDet;
    @FindBy(xpath = RbacOR.rptIssuesOnlyAccess)
    public WebElement rptIssuesOnlyAccess;
    @FindBy(xpath = RbacOR.rptIssuesExceptAccess)
    public WebElement rptIssuesExceptAccess;
    @FindBy(xpath = RbacOR.rptSelectIssues)
    public WebElement rptSelectIssues;
    @FindBy(xpath = RbacOR.rptIssuesHasChild)
    public WebElement rptIssuesHasChild;
    @FindBy(xpath = RbacOR.rptIssuesChildren)
    public WebElement rptIssuesChildren;
    @FindBy(xpath = RbacOR.rptIssuesSelected)
    public WebElement rptIssuesSelected;
    @FindBy(xpath = RbacOR.rptIssuesSave)
    public WebElement rptIssuesSave;
    @FindBy(xpath = RbacOR.rptIssuesClearAll)
    public WebElement rptIssuesClearAll;
    @FindBy(xpath = RbacOR.rptInstRptAdminYes)
    public WebElement rptInstRptAdminYes;
    @FindBy(xpath = RbacOR.rptInstRptAdminNo)
    public WebElement rptInstRptAdminNo;
    @FindBy(xpath = RbacOR.rptLocAccessAll)
    public WebElement rptLocAccessAll;
    @FindBy(xpath = RbacOR.rptLocAccessLmt)
    public WebElement rptLocAccessLmt;
    @FindBy(xpath = RbacOR.rptLocAccessViewDet)
    public WebElement rptLocAccessViewDet;
    @FindBy(xpath = RbacOR.rptLocOnlyAccess)
    public WebElement rptLocOnlyAccess;
    @FindBy(xpath = RbacOR.rptLocExceptAccess)
    public WebElement rptLocExceptAccess;
    @FindBy(xpath = RbacOR.rptSelectLoc)
    public WebElement rptSelectLoc;
    @FindBy(xpath = RbacOR.rptLocHasChild)
    public WebElement rptLocHasChild;
    @FindBy(xpath = RbacOR.rptLocNoChild)
    public WebElement rptLocNoChild;
    @FindBy(xpath = RbacOR.rptLocSelected)
    public WebElement rptLocSelected;
    @FindBy(xpath = RbacOR.rptLocSave)
    public WebElement rptLocSave;
    @FindBy(xpath = RbacOR.rptLocClearAll)
    public WebElement rptLocClearAll;
    @FindBy(xpath = RbacOR.qvRptCaseTypeNonePerms)
    public WebElement qvRptCaseTypeNonePerms;
    @FindBy(xpath = RbacOR.qvRptInsightsCaseTypePerms)
    public WebElement qvRptInsightsCaseTypePerms;
    @FindBy(xpath = RbacOR.qvRptGrpPerm)
    public WebElement qvRptGrpPerm;
    @FindBy(xpath = RbacOR.qvRptOtherPerm)
    public WebElement qvRptOtherPerm;
    @FindBy(xpath = RbacOR.qvRptIssueAccessPerm)
    public WebElement qvRptIssueAccessPerm;
    @FindBy(xpath = RbacOR.qvRptLocPerm)
    public WebElement qvRptLocPerm;
    @FindBy(xpath = RbacOR.qvOtherPerms)
    public WebElement qvOtherPerms;

    @FindBy(xpath = RbacOR.isConfigAdminYes)
    public WebElement isConfigAdminYes;
    @FindBy(xpath = RbacOR.isConfigAdminNo)
    public WebElement isConfigAdminNo;

    @FindBy(xpath = RbacOR.isDataImportAdminYes)
    public WebElement isDataImportAdminYes;
    @FindBy(xpath = RbacOR.isDataImportAdminNo)
    public WebElement isDataImportAdminNo;

    @FindBy(xpath = RbacOR.isMngrCaseApproverYes)
    public WebElement isMngrCaseApproverYes;
    @FindBy(xpath = RbacOR.isMngrCaseApproverNo)
    public WebElement isMngrCaseApproverNo;

    @FindBy(xpath = RbacOR.isDataShredderNo)
    public WebElement isDataShredderNo;
    @FindBy(xpath = RbacOR.isDataShredderYes)
    public WebElement isDataShredderYes;
    @FindBy(xpath = RbacOR.ShredOK)
    public WebElement ShredOK;

    @FindBy(xpath = RbacOR.isenableHomePageTrendingAnalyticsYes)
    public WebElement isenableHomePageTrendingAnalyticsYes;

    @FindBy(xpath = RbacOR.isLegalHoldAdminYes)
    public WebElement isLegalHoldAdminYes;

    @FindBy(xpath = RbacOR.isAuditLogAdminYes)
    public WebElement isAuditLogAdminYes;

    @FindBy(xpath = RbacOR.permissionSave)
    public WebElement permissionSave;
    @FindBy(xpath = RbacOR.managerAccessPerm)
    public WebElement managerAccessPerm;
    @FindBy(xpath = RbacOR.groupAccessPerm)
    public WebElement groupAccessPerm;

    @FindBy(xpath = RbacOR.quickViewPerm)
    public WebElement quickViewPerm;
    @FindBy(xpath = RbacOR.quickViewAssignedUsers)
    public WebElement quickViewAssignedUsers;

    //AssignRoleTouser.....
    @FindBy(xpath = RbacOR.quickviewUser)
    public WebElement quickviewUser;
    @FindBy(xpath = RbacOR.editAssignment)
    public WebElement editAssignment;
    @FindBy(xpath = RbacOR.enterRole)
    public WebElement enterRole;
    @FindBy(xpath = RbacOR.assignToRole)
    public WebElement assignToRole;
    @FindBy(xpath = RbacOR.assignYesButton)
    public WebElement assignYesButton;
    @FindBy(xpath = RbacOR.AllCases)
    public WebElement AllCases;
    @FindBy(xpath = RbacOR.Administration)
    public WebElement Administration;

    List<String> groupsList = new ArrayList<>();
    List<String> locationsList = new ArrayList<>();
    List<String> caseTypeOptionsList = new ArrayList<>();
    List<String> vcGroupsList = new ArrayList<>();
    List<String> vcLocationsList = new ArrayList<>();
    List<String> vcIssueAccessList = new ArrayList<>();
    List<String> irGroupsList = new ArrayList<>();
    List<String> irLocationsList = new ArrayList<>();
    List<String> irIssueAccessList = new ArrayList<>();
    List<String> caGroupsList = new ArrayList<>();
    List<String> caLocationsList = new ArrayList<>();
    List<String> paGroupsList = new ArrayList<>();
    List<String> paLocationsList = new ArrayList<>();
    List<String> enterCasesOptionsList = new ArrayList<>();
    List<String> rptCaseTypeOptionsList = new ArrayList<>();
    List<String> rptCaseInsightsOptionsList = new ArrayList<>();


    public void mpUserRole() throws Throwable {
        try {
            BrowserUtilities.waitAndClickButton(mpUserRoleYes);
            log.info("User enables Manager Portal User role");
        } catch (Exception e) {
            log.info("User is not able to select " + e.getMessage());
            Assert.fail("User is not able to select  " + e.getMessage());
        }

    }

    public void selectGrpAccessAll(String roles, String option) throws Throwable {
        try {
            if (roles.equalsIgnoreCase("Manager Portal")) {
                BrowserUtilities.waitAndClickButton(mpGrpAccessAll);
            } else if (roles.equalsIgnoreCase("limited User")) {
                BrowserUtilities.waitAndClickButton(lmtPAGrpAccessAll);
            } else if (roles.equalsIgnoreCase("View Cases")) {
                BrowserUtilities.waitAndClickButton(vcGrpAccessAll);
            } else if (roles.equalsIgnoreCase("Case Admin")) {
                BrowserUtilities.waitAndClickButton(caGrpAccessAll);
            } else if (roles.equalsIgnoreCase("Profile Admin")) {
                BrowserUtilities.waitAndClickButton(paGrpAccessAll);
            } else if (roles.equalsIgnoreCase("insights reporting")) {
                BrowserUtilities.waitAndClickButton(rptGrpAccessAll);
            }

        } catch (Exception e) {
            log.info("User is not able to select " + roles + e.getMessage());
            Assert.fail("User is not able to select  " + e.getMessage());
        }

    }

    public void selectLocAccessAll(String roles, String option) throws Throwable {
        try {
            if (roles.equalsIgnoreCase("Manager Portal")) {
                BrowserUtilities.waitAndClickButton(mpLocAccessAll);
            } else if (roles.equalsIgnoreCase("limited User")) {
                BrowserUtilities.waitAndClickButton(lmtPALocAccessAll);
            } else if (roles.equalsIgnoreCase("View Cases")) {
                BrowserUtilities.waitAndClickButton(vcLocAccessAll);
            } else if (roles.equalsIgnoreCase("Case Admin")) {
                BrowserUtilities.waitAndClickButton(caLocAccessAll);
            } else if (roles.equalsIgnoreCase("Profile Admin")) {
                BrowserUtilities.waitAndClickButton(paLocAccessAll);
            } else if (roles.equalsIgnoreCase("insights reporting")) {
                BrowserUtilities.waitAndClickButton(rptLocAccessAll);
            }

        } catch (Exception e) {
            log.info("User is not able to select " + e.getMessage());
            Assert.fail("User is not able to select  " + e.getMessage());
        }

    }

    public void selectIssueAccessAll(String roles, String option) throws IOException {
        try {
            if (roles.equalsIgnoreCase("View Cases")) {
                BrowserUtilities.waitAndClickButton(vcIssueAccessAll);
            } else if (roles.equalsIgnoreCase("Insights Reporting")) {
                BrowserUtilities.waitAndClickButton(rptIssueAccessAll);
            }
        } catch (Exception e) {
            log.info("User is not able to select " + e.getMessage());
            Assert.fail("User is not able to select  " + e.getMessage());
        }

    }


    public void quickViewPermission() throws Throwable {
        try {
            BrowserUtilities.waitAndClickButton(quickViewPerm);

        } catch (Exception e) {
            Assert.fail("User is not able to see roles permissions " + e.getMessage());
        }

    }

    public void editPermissions() throws Throwable {
        try {
            BrowserUtilities.waitAndClickButton(mpEditPermi);
            log.info("User can edit the role permissions ");
        } catch (Exception e) {
            log.info("User can edit the role permissions " + e.getMessage());
        }

    }

    public void selectLmtGrpNEdit(String role) throws Throwable {
        try {
            if (role.equalsIgnoreCase("manager portal")) {
                BrowserUtilities.waitAndClickButton(mpGrpAccessLmt);
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(mpViewDetGrpLmt);
            } else if (role.equalsIgnoreCase("profile admin")) {
                BrowserUtilities.waitAndClickButton(paGrpAccessLmt);
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(paGrpAccessViewDetail);
            } else if (role.equalsIgnoreCase("view cases")) {
                BrowserUtilities.waitAndClickButton(vcGrpAccessLmt);
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(vcGrpAccessLmtViewDetails);
            } else if (role.equalsIgnoreCase("case admin")) {
                BrowserUtilities.waitAndClickButton(caGrpAccessLimited);
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(caGrpAccessLmtViewDetail);
            } else if (role.equalsIgnoreCase("insights reporting")) {
                BrowserUtilities.waitAndClickButton(rptGrpAccessLmt);
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(rptGrpAccessViewDet);
            } else {
                log.info("Invalid role - " + role);
                Assert.fail("Invalid role - " + role);
            }

            log.info("Click on Limited Group Access View/Details successful for role - " + role);

        } catch (Exception e) {
            log.info("Click on Limited Group Access View/Details successful for role - " + role);
            Assert.fail("Click on Limited Group Access View/Details successful for role - " + e.getMessage());
        }

    }

    public void selectLmtIssueNEdit(String role) throws Throwable {
        try {
            if (role.equalsIgnoreCase("View Cases")) {
                BrowserUtilities.waitAndClickButton(vcIssueAccessLmt);
                TimeUnit.SECONDS.sleep(1);
                BrowserUtilities.waitAndClickButton(vcIssueAccessLmtViewDetails);
            } else if (role.equalsIgnoreCase("Insights Reporting")) {
                BrowserUtilities.waitAndClickButton(rptIssueAccessLmt);
                TimeUnit.SECONDS.sleep(1);
                BrowserUtilities.waitAndClickButton(rptIssueAccessViewDet);
            }
        } catch (Exception e) {
            log.info("Failed to click on Role and edit details " + e.getMessage());
            Assert.fail("Failed to click on Role and edit details " + e.getMessage());
        }

    }

    public void selectLmtLocNEdit(String role) throws Throwable {
        try {
            if (role.equalsIgnoreCase("manager portal")) {
                BrowserUtilities.waitAndClickButton(mpLocAccessLmt);
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(mpViewDetLocLmt);
            } else if (role.equalsIgnoreCase("profile admin")) {
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(paLocAccessLmt);
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(paLocAccessViewDetail);
            } else if (role.equalsIgnoreCase("view cases")) {
                BrowserUtilities.waitAndClickButton(vcLocAccessLmt);
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(vcLocAccessLmtViewDetails);
            } else if (role.equalsIgnoreCase("case admin")) {
                BrowserUtilities.waitAndClickButton(caLocAccessLimited);
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(caLocAccessLmtViewDetail);
            } else if (role.equalsIgnoreCase("insights reporting")) {
                BrowserUtilities.waitAndClickButton(rptLocAccessLmt);
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(rptLocAccessViewDet);
            } else {
                log.info("Invalid role - " + role);
                Assert.fail("Invalid role - " + role);
            }

            log.info("Click on Limited Location Access View/Details successful for role - " + role);

        } catch (Exception e) {
            log.info("Invalid role - " + role + e.getMessage());
            Assert.fail("Invalid role - " + role);
        }
    }

    public void selectOption(String role, String option) throws InterruptedException, IOException {
        try {
            if (option.contains("Group")) {
                if (role.equalsIgnoreCase("manager portal") && option.equalsIgnoreCase("only group selected")) {
                    groupsList = selectGrpLocOption(role, option, mpGrpOnlyAccess, RbacOR.mpGrpSelected, mpGrpClearAll, mpSelectGrp, mpGrpNoChild, mpGrpHasChild);
                } else if (role.equalsIgnoreCase("manager portal") && option.equalsIgnoreCase("all group except selected")) {
                    groupsList = selectGrpLocOption(role, option, mpGrpExceptAccess, RbacOR.mpGrpSelected, mpGrpClearAll, mpSelectGrp, mpGrpNoChild, mpGrpHasChild);
                } else if (role.equalsIgnoreCase("profile admin") && option.equalsIgnoreCase("only group selected")) {
                    paGroupsList = selectGrpLocOption(role, option, paGrpOnlyAccess, RbacOR.paGrpSelected, paGrpClearAll, paSelectGrp, paGrpNoChild, paGrpHasChild);
                } else if (role.equalsIgnoreCase("profile admin") && option.equalsIgnoreCase("all group except selected")) {
                    paGroupsList = selectGrpLocOption(role, option, paGrpExceptAccess, RbacOR.paGrpSelected, paGrpClearAll, paSelectGrp, paGrpNoChild, paGrpHasChild);
                } else if (role.equalsIgnoreCase("view cases") && option.equalsIgnoreCase("only group selected")) {
                    vcGroupsList = selectGrpLocOption(role, option, vcGrpOnlyAccess, RbacOR.vcGrpSelected, vcGrpClearAll, vcSelectGrp, vcGrpNoChild, vcGrpHasChild);
                } else if (role.equalsIgnoreCase("view cases") && option.equalsIgnoreCase("all group except selected")) {
                    vcGroupsList = selectGrpLocOption(role, option, vcGrpExceptAccess, RbacOR.vcGrpSelected, vcGrpClearAll, vcSelectGrp, vcGrpNoChild, vcGrpHasChild);
                } else if (role.equalsIgnoreCase("case admin") && option.equalsIgnoreCase("only group selected")) {
                    caGroupsList = selectGrpLocOption(role, option, caGrpOnlyAccess, RbacOR.caGrpSelected, caGrpClearAll, caSelectGrp, caGrpNoChild, caGrpHasChild);
                } else if (role.equalsIgnoreCase("case admin") && option.equalsIgnoreCase("all group except selected")) {
                    caGroupsList = selectGrpLocOption(role, option, caGrpExceptAccess, RbacOR.caGrpSelected, caGrpClearAll, caSelectGrp, caGrpNoChild, caGrpHasChild);
                } else if (role.equalsIgnoreCase("insights reporting") && option.equalsIgnoreCase("only group selected")) {
                    irGroupsList = selectGrpLocOption(role, option, rptGrpOnlyAccess, RbacOR.rptGrpSelected, rptGrpClearAll, rptSelectGrp, rptGrpNoChild, rptGrpHasChild);
                } else if (role.equalsIgnoreCase("insights reporting") && option.equalsIgnoreCase("all group except selected")) {
                    irGroupsList = selectGrpLocOption(role, option, rptGrpExceptAccess, RbacOR.rptGrpSelected, rptGrpClearAll, rptSelectGrp, rptGrpNoChild, rptGrpHasChild);
                } else {
                    log.info("Invalid role/option parameters passed - [" + role + ", " + option + "]");
                    Assert.fail("Invalid role/option parameters passed - [" + role + ", " + option + "]");
                }

            } else if (option.contains("Location")) {

                if (role.equalsIgnoreCase("manager portal") && option.equalsIgnoreCase("only location selected")) {
                    locationsList = selectGrpLocOption(role, option, mpLocOnly, RbacOR.mpLocSelected, mpLocClearAll, mpSelectLoc, mpLocNoChild, mpLocHasChild);
                } else if (role.equalsIgnoreCase("manager portal") && option.equalsIgnoreCase("all location except selected")) {
                    locationsList = selectGrpLocOption(role, option, mpLocExcept, RbacOR.mpLocSelected, mpLocClearAll, mpSelectLoc, mpLocNoChild, mpLocHasChild);
                } else if (role.equalsIgnoreCase("profile admin") && option.equalsIgnoreCase("only location selected")) {
                    paLocationsList = selectGrpLocOption(role, option, paLocOnlyAccess, RbacOR.paLocSelected, paLocClearAll, paSelectLoc, paLocNoChild, paLocHasChild);
                } else if (role.equalsIgnoreCase("profile admin") && option.equalsIgnoreCase("all location except selected")) {
                    paLocationsList = selectGrpLocOption(role, option, paLocExceptAccess, RbacOR.paLocSelected, paLocClearAll, paSelectLoc, paLocNoChild, paLocHasChild);
                } else if (role.equalsIgnoreCase("view cases") && option.equalsIgnoreCase("only location selected")) {
                    vcLocationsList = selectGrpLocOption(role, option, vcLocOnlyAccess, RbacOR.vcLocSelected, vcLocClearAll, vcSelectLoc, vcLocNoChild, vcLocHasChild);
                } else if (role.equalsIgnoreCase("view cases") && option.equalsIgnoreCase("all location except selected")) {
                    vcLocationsList = selectGrpLocOption(role, option, vcLocExceptAccess, RbacOR.vcLocSelected, vcLocClearAll, vcSelectLoc, vcLocNoChild, vcLocHasChild);
                } else if (role.equalsIgnoreCase("case admin") && option.equalsIgnoreCase("only location selected")) {
                    caLocationsList = selectGrpLocOption(role, option, caLocOnlyAccess, RbacOR.caLocSelected, caLocClearAll, caSelectLoc, caLocNoChild, caLocHasChild);
                } else if (role.equalsIgnoreCase("case admin") && option.equalsIgnoreCase("all location except selected")) {
                    caLocationsList = selectGrpLocOption(role, option, caLocExceptAccess, RbacOR.caLocSelected, caLocClearAll, caSelectLoc, caLocNoChild, caLocHasChild);
                } else if (role.equalsIgnoreCase("insights reporting") && option.equalsIgnoreCase("only location selected")) {
                    irLocationsList = selectGrpLocOption(role, option, rptLocOnlyAccess, RbacOR.rptLocSelected, rptLocClearAll, rptSelectLoc, rptLocNoChild, rptLocHasChild);
                } else if (role.equalsIgnoreCase("insights reporting") && option.equalsIgnoreCase("all location except selected")) {
                    irLocationsList = selectGrpLocOption(role, option, rptLocExceptAccess, RbacOR.rptLocSelected, rptLocClearAll, rptSelectLoc, rptLocNoChild, rptLocHasChild);
                } else {
                    log.info("Invalid role/option parameters passed - [" + role + ", " + option + "]");
                    Assert.fail("Invalid role/option parameters passed - [" + role + ", " + option + "]");
                }

            } else if (option.contains("Issue")) {

                if (role.equalsIgnoreCase("view cases") && option.equalsIgnoreCase("only Issue selected")) {
                    vcIssueAccessList = selectIssueOption(role, option, vcIssuesOnlyAccess, RbacOR.vcIssuesSelected, vcIssueAccessClearAll, vcSelectIssues, vcIssuesHasChild);
                } else if (role.equalsIgnoreCase("view cases") && option.equalsIgnoreCase("all Issues except selected")) {
                    vcIssueAccessList = selectIssueOption(role, option, vcIssuesExceptAccess, RbacOR.vcIssuesSelected, vcIssueAccessClearAll, vcSelectIssues, vcIssuesHasChild);
                } else if (role.equalsIgnoreCase("insights reporting") && option.equalsIgnoreCase("only Issue selected")) {
                    irIssueAccessList = selectIssueOption(role, option, rptIssuesOnlyAccess, RbacOR.rptIssuesSelected, rptIssuesClearAll, rptSelectIssues, rptIssuesHasChild);
                } else if (role.equalsIgnoreCase("insights reporting") && option.equalsIgnoreCase("all Issues except selected")) {
                    irIssueAccessList = selectIssueOption(role, option, rptIssuesExceptAccess, RbacOR.rptIssuesSelected, rptIssuesClearAll, rptSelectIssues, rptIssuesHasChild);
                } else {
                    log.info("Invalid role/option parameters passed - [" + role + ", " + option + "]");
                    Assert.fail("Invalid role/option parameters passed - [" + role + ", " + option + "]");
                }
            }
        } catch (Exception e) {
            log.info("Invalid roles and options " + e.getMessage());
            Assert.fail("Invalid roles and options " + e.getMessage());
        }


    }


    private List<String> selectGrpLocOption(String role, String option, WebElement optionAccess,
                                            String optionSelected, WebElement optionClearAll, WebElement selectOption, WebElement optionNoChild, WebElement optionHasChild) throws IOException, InterruptedException {
        List<String> optionList = new ArrayList<>();
        BrowserUtilities.waitAndClickButton(optionAccess);
        log.info("User selects view cases with option - " + option + ", for role - " + role);

        List<WebElement> we = driver.findElements(By.xpath(optionSelected));
        if (we.size() > 0) {
            BrowserUtilities.waitAndClickButton(optionClearAll);
        }

        BrowserUtilities.waitAndClickButton(selectOption);
        BrowserUtilities.waitAndClickButton(optionNoChild);
        TimeUnit.SECONDS.sleep(2);
        BrowserUtilities.waitAndClickButton(selectOption);
        BrowserUtilities.waitAndClickButton(optionHasChild);

        List<WebElement> elemList = driver.findElements(By.xpath(optionSelected));
        for (WebElement e : elemList) {
            optionList.add(e.getText());
        }

        return optionList;
    }

    private List<String> selectIssueOption(String role, String option, WebElement optionAccess,
                                           String optionSelected, WebElement optionClearAll, WebElement selectOption, WebElement optionHasChild) throws IOException {
        List<String> optionList = new ArrayList<>();
        BrowserUtilities.waitAndClickButton(optionAccess);
        log.info("User selects view cases with option - " + option + ", for role - " + role);

        List<WebElement> we = driver.findElements(By.xpath(optionSelected));
        if (we.size() > 0) {
            BrowserUtilities.waitAndClickButton(optionClearAll);
        }

        BrowserUtilities.waitAndClickButton(selectOption);
        BrowserUtilities.waitAndClickButton(optionHasChild);

        List<WebElement> elemList = driver.findElements(By.xpath(optionSelected));
        for (WebElement e : elemList) {
            optionList.add(e.getAttribute("data-text"));
        }

        return optionList;
    }

    public void savePermissions() throws Throwable {
        try {
            BrowserUtilities.waitAndClickButton(permissionSave);
            TimeUnit.SECONDS.sleep(3);
            log.info("Role permission saved successfully ");
        } catch (Exception e) {
            log.info("Failed to save permission " + e.getMessage());
            Assert.fail("Failed to saved permission " + e.getMessage());
        }

    }

    public void saveMPRolePermi(String permission) throws Throwable {
        try {
            if (permission.equalsIgnoreCase("group")) {
                BrowserUtilities.waitAndClickButton(mpGrpSave);
            } else if (permission.equalsIgnoreCase("location")) {
                BrowserUtilities.waitAndClickButton(mpLocSave);
            }
            log.info("Permissions saved successfully for " + permission);
        } catch (Exception e) {
            log.info("Failed to save MP user permission . " + e.getMessage());
            Assert.fail("Failed to save MP user permissions. " + e.getMessage());
        }
    }

    public void enableLmtUser() throws Throwable {
        try {
            BrowserUtilities.waitAndClickButton(limitedRoleYes);

        } catch (Exception e) {
            Assert.fail("Failed to save Limited user permissions. " + e.getMessage());
        }

    }

    public void saveLmtUserpermi(String option) throws InterruptedException, IOException {
        try {
            if (option.equalsIgnoreCase("group")) {
                log.info("User saves " + option + "permissions");
                BrowserUtilities.waitAndClickButton(lmtPAGrpPermSave);
            } else if (option.equalsIgnoreCase("location")) {
                //click(lmtPALocPermSave);
//				click(lmtPALocAccessViewDet);
//				paLocationsList.clear();
//				List<WebElement> we = driver.findElements(By.xpath(RbacOR.lmtPALocSelected));
//				for(WebElement e : we){
//					paLocationsList.add(e.getText().trim());
//				}
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(lmtPALocPermSave);
                log.info("Successfully saved Limited user permissions. ");
            }
        } catch (Exception e) {
            log.info("Failed to save Limited user permissions. " + e.getMessage());
            Assert.fail("Failed to save Limited user permissions. " + e.getMessage());
        }


    }

    public void profileAdminLocAccess(String option) throws InterruptedException, IOException {
        try {
            BrowserUtilities.waitAndClickButton(lmtPALocAccessLmt);
            BrowserUtilities.waitAndClickButton(lmtPALocAccessViewDet);
            log.info(
                    "User select, profile admin group access as " + option + " and click on edit details");
        } catch (Exception e) {
            log.info("User is not able to select profile admin group access as " + option + " and click on edit details");
        }
    }

    public void enableConfigAdmin() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(lmtConfigAdminYes);
            log.info("User enables configuration admin for Limited user");
        } catch (Exception e) {
            log.info("User is not able to enable configuration admin for Limited user");
        }
    }

    public void enableDataIntegAdmin() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(lmtDataInteAdminYes);
            log.info("User enable data integration admin for Limited user");
        } catch (Exception e) {
            log.info("User is not able to enable data integration admin for Limited user");
        }
    }

    public void enableRoleToEnterCases() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(enterCasesRoleYes);
            BrowserUtilities.waitAndClickButton(enterCaseViewDetails);
            log.info("User enables the role to enter cases and edit detail");
        } catch (Exception e) {
            log.info("User is not able to enables the role to enter cases and edit detail");
        }

    }

    public void saveCaseEntryPermissions() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(enterCaseSave);
        } catch (Exception e) {
            log.info("User is not able to save case entry permissions");
        }

    }

    public void enableViewCases() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(viewCasesYes);
            log.info("User enables View cases permission");
        } catch (Exception e) {
            log.info("User is not able to enables View Cases permission");
        }

    }

    public void vcLmtNEditDetails(String accessType) throws IOException {

        try {
            if (accessType.contains("Case type")) {
                BrowserUtilities.waitAndClickButton(vcCaseTypeLmt);
                BrowserUtilities.waitAndClickButton(vcCaseTypeViewDetails);
            } else if (accessType.contains("Group access")) {
                BrowserUtilities.waitAndClickButton(vcGrpAccessLmt);
                BrowserUtilities.waitAndClickButton(vcGrpAccessLmtViewDetails);
            } else if (accessType.contains("Issue access")) {
                BrowserUtilities.waitAndClickButton(vcIssueAccessLmt);
                BrowserUtilities.waitAndClickButton(vcIssueAccessLmtViewDetails);
            } else if (accessType.contains("Location access")) {
                BrowserUtilities.waitAndClickButton(vcLocAccessLmt);
                BrowserUtilities.waitAndClickButton(vcLocAccessLmtViewDetails);
            } else {
                log.info("Invalid access type " + accessType);
                Assert.fail("Invalid access type " + accessType);
            }
            log.info(
                    "User selects option view cases " + accessType + " and Edit details");
        } catch (Exception e) {
            log.info("User is not able to select option view cases " + accessType + " and Edit details");
        }

    }

    public void caseTypeOptions(List<String> optionList) throws IOException {
        caseTypeOptionsList.clear();
        caseTypeOptionsList.addAll(optionList);
        resetVcCaseTypeOptions();
        for (String option : optionList) {
            try {
                if (option.equalsIgnoreCase("er")) {
                    BrowserUtilities.waitAndClickButton(vcCaseTypeER);
                } else if (option.equalsIgnoreCase("inv")) {
                    BrowserUtilities.waitAndClickButton(vcCaseTypeINV);
                } else if (option.equalsIgnoreCase("ei")) {
                    BrowserUtilities.waitAndClickButton(vcCaseTypeEI);
                } else if (option.equalsIgnoreCase("ph")) {
                    BrowserUtilities.waitAndClickButton(vcCaseTypePH);
                } else {
                    log.info("Invalid option - " + option);
                    Assert.fail("Invalid option - " + option);
                }

                log.info("User selects options from Case Type permission - " + option);
            } catch (Exception e) {
                log.info("User is not able to selects options from Case Type permission ");
            }
        }
    }


    private void resetVcCaseTypeOptions() throws IOException {
        try {
            if (vcCaseTypeER.getAttribute("prevval") != null) {
                BrowserUtilities.waitAndClickButton(vcCaseTypeER);
            }

            if (vcCaseTypeINV.getAttribute("prevval") != null) {
                BrowserUtilities.waitAndClickButton(vcCaseTypeINV);
            }
            if (vcCaseTypeEI.getAttribute("prevval") != null) {
                BrowserUtilities.waitAndClickButton(vcCaseTypeEI);
            }

            if (vcCaseTypePH.getAttribute("prevval") != null) {
                BrowserUtilities.waitAndClickButton(vcCaseTypePH);
            }

        } catch (Exception e) {
            log.info(e.getMessage());
            Assert.fail(e.getMessage());
        }
// TODO Auto-generated method stub

    }

    public void saveVCPermission(String caseType) throws IOException {
        try {
            if (caseType.equalsIgnoreCase("Case Type")) {
                BrowserUtilities.waitAndClickButton(vcCaseTypeSave);
            } else if (caseType.equalsIgnoreCase("Group access")) {
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(vcGrpSave);
            } else if (caseType.equalsIgnoreCase("Issue access")) {
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(vcIssuesSave);
            } else if (caseType.equalsIgnoreCase("Location access")) {
                //click(vcLocSave);
                //click(vcLocAccessLmtViewDetails);
//				vcLocationsList.clear();
//				List<WebElement> we = driver.findElements(By.xpath(RbacOR.vcLocSelected));
//				for(WebElement e : we){
//					vcLocationsList.add(e.getText().trim());
//				}
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(vcLocSave);
            }
            log.info("User saved the " + caseType + "permissions");
        } catch (Exception e) {
            log.info("User is not able to save the " + caseType + "permissions");
        }

    }

    public void enablesCaseAdminRole() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(caViewCasePermYes);
            log.info("User enables Case Admin permission ");
        } catch (Exception e) {
            log.info("User is not able to enable Case Admin permission ");
        }
    }

    public void caLmtEditDetails(String option) throws IOException {
        try {
            if (option.contains("Group access")) {
                BrowserUtilities.waitAndClickButton(caGrpAccessLimited);
                BrowserUtilities.waitAndClickButton(caGrpAccessLmtViewDetail);
            } else if (option.contains("Location access")) {
                BrowserUtilities.waitAndClickButton(caLocAccessLimited);
                BrowserUtilities.waitAndClickButton(caLocAccessLmtViewDetail);
            }
            log.info("User enables " + option + "Limited and edit details ");
        } catch (Exception e) {
            log.info("User is not able to enables " + option + "Limited and edit details ");
        }
    }

    public void saveCaGrpLocPermi(String option) throws IOException {
        try {
            if (option.equalsIgnoreCase("Group access")) {
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(caGrpSave);
            } else if (option.equalsIgnoreCase("Location access")) {
//				click(caLocSave);
//				click(caLocAccessLmtViewDetail);
//				caLocationsList.clear();
//				List<WebElement> we = driver.findElements(By.xpath(RbacOR.caLocSelected));
//				for(WebElement e : we){
//					caLocationsList.add(e.getText().trim());
//				}
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(caLocSave);
            }
            log.info("User save " + option + "permission succesfully");
        } catch (Exception e) {
            log.info("User is unable to save " + option + "permission");
        }

    }

    public void enableProfileAdminRole() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(profileAdminYes);
            log.info("User enables Profile Admin role sucessfully");
        } catch (Exception e) {
            log.info("User is not able to enables Profile Admin role ");
        }
    }


    public void savePAPermi(String option) throws IOException {
        try {
            if (option.equalsIgnoreCase("Group access")) {
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(paGrpSave);
            } else if (option.equalsIgnoreCase("Location access")) {
//				click(paLocSave);
//				click(paLocAccessViewDetail);
//				paLocationsList.clear();
//				List<WebElement> we = driver.findElements(By.xpath(RbacOR.paLocSelected));
//				for(WebElement e : we){
//					paLocationsList.add(e.getText().trim());
//				}
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(paLocSave);
            }
            log.info("User saved " + option + "permissions");
        } catch (Exception e) {
            log.info("User is not able to save " + option + " permissions");
        }

    }

    public void enablesCofigAdmin() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(isConfigAdminYes);
            log.info("User enables configuration Admin Role sucessfully ");
        } catch (Exception e) {
            log.info("User is not able enable configuration Admin Role ");
        }
    }

    public void enableDataInteAdminRole() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(isDataImportAdminYes);
            log.info("User enables Data Integration Admin Role sucessfully ");
        } catch (Exception e) {
            log.info("User is not able enable Data Integration Admin Role ");
        }

    }

    public void verifyGrpAccess(String role, String option) throws IOException {
        if (role.equalsIgnoreCase("limited user")) {
            verifyGroupsList(option, qcLmtPAGrpPerm, groupsList);
        } else if (role.equalsIgnoreCase("manager portal")) {
            verifyGroupsList(option, qvMpGrpPerm, groupsList);
        } else if (role.equalsIgnoreCase("View Cases")) {
            verifyGroupsList(option, qvVcGrpPerm, vcGroupsList);
        } else if (role.equalsIgnoreCase("Insights Reporting")) {
            verifyGroupsList(option, qvRptGrpPerm, irGroupsList);
        } else if (role.equalsIgnoreCase("Case Admin")) {
            verifyGroupsList(option, qvCaGrpPerm, caGroupsList);
        } else if (role.equalsIgnoreCase("Profile Admin")) {
            verifyGroupsList(option, qvPaGrpPerm, paGroupsList);
        } else {
            log.info("Invalid role - " + role);
            Assert.fail("Invalid role - " + role);
        }

    }

    public void verifyLocAccess(String role, String option) throws IOException {
        if (role.equalsIgnoreCase("limited user")) {
            verifyLocationsList(option, qcLmtPALocPerm, locationsList);
        } else if (role.equalsIgnoreCase("manager portal")) {
            verifyLocationsList(option, qvMpLocPerm, locationsList);
        } else if (role.equalsIgnoreCase("View Cases")) {
            verifyLocationsList(option, qvVcLocPerm, vcLocationsList);
        } else if (role.equalsIgnoreCase("Insights Reporting")) {
            verifyLocationsList(option, qvRptLocPerm, irLocationsList);
        } else if (role.equalsIgnoreCase("Case Admin")) {
            verifyLocationsList(option, qvCaLocPerm, caLocationsList);
        } else if (role.equalsIgnoreCase("Profile Admin")) {
            verifyLocationsList(option, qvPaLocPerm, paLocationsList);
        } else {
            log.info("Invalid role - " + role);
            Assert.fail("Invalid role - " + role);
        }

    }

    public void verifyIssueAccess(String role, String option) throws IOException {
        if (role.equalsIgnoreCase("View Cases")) {
            verifyIssueAccessList(option, qvVcIssueAccessPerm, vcIssueAccessList);
        } else if (role.equalsIgnoreCase("Insights Reporting")) {
            verifyIssueAccessList(option, qvRptIssueAccessPerm, irIssueAccessList);
        } else {
            log.info("Invalid role - " + role);
            Assert.fail("Invalid role - " + role);
        }

    }


    private void verifyIssueAccessList(String option, WebElement issueAccessElement, List<String> expectedIssueAccessList) throws IOException {
        String issueAccess = issueAccessElement.getText();
        if (option.equalsIgnoreCase("all")) {
            if (issueAccess.equalsIgnoreCase("all")) {
                log.info("Expected Issues - " + option
                        + " matched with Actual Issues - " + issueAccess);
            } else {
                log.info("Expected Issues - " + option
                        + " did not match with Actual Issues - " + issueAccess);
            }
        } else if (option.equalsIgnoreCase("only Issue selected")) {
            List<String> actualIssueAccessList = new ArrayList<>();
            if (issueAccess.contains(", ")) {
                actualIssueAccessList = Arrays.asList(issueAccess.split(", "));
            } else {
                actualIssueAccessList = Arrays.asList(issueAccess.split(","));
            }

            if (expectedIssueAccessList.size() != actualIssueAccessList.size()) {
                log.info("Expected Issues - " + expectedIssueAccessList
                        + " but actual Issues list is - " + actualIssueAccessList);
            } else {
                if (expectedIssueAccessList.containsAll(expectedIssueAccessList)) {
                    log.info("Expected Issues - " + expectedIssueAccessList
                            + " matched with actual Issues list - " + actualIssueAccessList);
                } else {
                    log.info("Expected Issues - " + expectedIssueAccessList
                            + " did not match with actual Issues list - " + actualIssueAccessList);
                }
            }

        } else if (option.equalsIgnoreCase("All Issues Except selected")) {
            if (!issueAccess.startsWith("All Issues Except - ")) {
                log.info("Expected Issues are not excluded - " + issueAccess);
            } else {
                List<String> actualIssueAccessList = new ArrayList<>();
                if (issueAccess.contains(", ")) {
                    actualIssueAccessList = Arrays.asList(issueAccess.substring(issueAccess.indexOf("- ") + 2).split(", "));
                } else {
                    actualIssueAccessList = Arrays.asList(issueAccess.substring(issueAccess.indexOf("- ") + 2).split(","));
                }
                if (expectedIssueAccessList.size() != actualIssueAccessList.size()) {
                    log.info("Expected Issues excluded are - " + expectedIssueAccessList
                            + " but actual Issues excluded are - " + actualIssueAccessList);
                } else {
                    if (expectedIssueAccessList.containsAll(actualIssueAccessList)) {
                        log.info("Expected Issues excluded - " + expectedIssueAccessList
                                + " matched with actual Issues excluded - " + actualIssueAccessList);
                    } else {
                        log.info("Expected Issues excluded - " + expectedIssueAccessList
                                + " did not match with actual Issues excluded - " + actualIssueAccessList);
                    }
                }
            }

        } else {
            log.info("Invalid option - " + option);
        }
    }

    public void verifyGroupsList(String option, WebElement grpWebElement, List<String> expectedGroupList) throws IOException {
        String groups = grpWebElement.getText();
        if (option.equalsIgnoreCase("all")) {
            if (groups.equalsIgnoreCase("all")) {
                log.info("Expected Group Access - " + option
                        + " matched with Actual Group Access - " + groups);
            } else {
                log.info("Expected Group Access - " + option
                        + " did not match with Actual Group Access - " + groups);
            }
        } else if (option.equalsIgnoreCase("only Group selected")) {
            List<String> actualGroupList = Arrays.asList(groups.split(", "));
            if (expectedGroupList.size() != actualGroupList.size()) {
                log.info("Expected Groups - " + expectedGroupList
                        + " but actual groups list is - " + actualGroupList);
            } else {
                if (expectedGroupList.containsAll(actualGroupList)) {
                    log.info("Expected Groups - " + expectedGroupList
                            + " matched with actual groups list - " + actualGroupList);
                } else {
                    log.info("Expected Groups - " + expectedGroupList
                            + " did not match with actual groups list - " + actualGroupList);
                }
            }

        } else if (option.equalsIgnoreCase("All Group Except selected")) {
            if (!groups.startsWith("All Groups Except - ")) {
                log.info("Expected Groups are not excluded - " + groups);
            } else {
                List<String> actualGroupList = Arrays.asList(groups.substring(groups.indexOf("- ") + 2).split(", "));
                if (expectedGroupList.size() != actualGroupList.size()) {
                    log.info("Expected Groups excluded are - " + expectedGroupList
                            + " but actual groups excluded are - " + actualGroupList);
                } else {
                    if (expectedGroupList.containsAll(actualGroupList)) {
                        log.info("Expected Groups excluded - " + expectedGroupList
                                + " matched with actual groups excluded - " + actualGroupList);
                    } else {
                        log.info("Expected Groups excluded - " + expectedGroupList
                                + " did not match with actual groups excluded - " + actualGroupList);
                    }
                }
            }

        } else {
            log.info("Invalid option - " + option);
        }
    }

    public void verifyLocationsList(String option, WebElement locPerm, List<String> expectedLocList) throws IOException {
        String locations = locPerm.getText();
        if (option.equalsIgnoreCase("all")) {
            if (locations.equalsIgnoreCase("all")) {
                log.info("Expected Location Access - " + option
                        + " matched with Actual Location Access - " + locations);
            } else {
                log.info("Expected Location Access - " + option
                        + " did not match with Actual Location Access - " + locations);
            }
        } else if (option.equalsIgnoreCase("only Location selected")) {
            List<String> actualLocList = Arrays.asList(locations.split(", "));

            if (expectedLocList.size() != actualLocList.size()) {
                log.info("Expected Locations - " + expectedLocList
                        + " but actual locations list is - " + actualLocList);
            } else {
                if (expectedLocList.containsAll(actualLocList)) {
                    log.info("Expected Locations - " + expectedLocList
                            + " matched with actual locations list - " + actualLocList);
                } else {
                    log.info("Expected Locations - " + expectedLocList
                            + " did not match with actual locations list - " + actualLocList);
                }
            }

        } else if (option.equalsIgnoreCase("All Location Except selected")) {
            if (!locations.startsWith("All Locations Except - ")) {
                log.info("Expected Locations are not excluded - " + locations);
            } else {
                List<String> actualLocList = Arrays.asList(locations.substring(locations.indexOf("- ") + 2).split(", "));
                if (expectedLocList.size() != actualLocList.size()) {
                    log.info("Expected Locations excluded are - " + expectedLocList
                            + " but actual locations excluded are - " + actualLocList);
                } else {
                    if (expectedLocList.containsAll(actualLocList)) {
                        log.info("Expected Locations excluded - " + expectedLocList
                                + " matched with actual locations excluded - " + actualLocList);
                    } else {
                        log.info("Expected Locations excluded - " + expectedLocList
                                + " did not match with actual locations excluded - " + actualLocList);
                    }
                }
            }

        } else {
            log.info("Invalid option - " + option);
        }
    }

    //important for validation in user
    public void verifyOtherRole(String role, String otherRole) throws IOException {
        if (role.equalsIgnoreCase("limited user")) {
            if (qvLmtOtherPerms.getText().contains(otherRole)) {
                log.info(otherRole + " is enabled for limited user role");
            } else {
                log.info(otherRole + " is not enabled for limited user role");
            }
        } else {
            log.info("Invalid role - " + role);
        }
    }

    public void enableProfileAdmin() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(lmtProfileAdminYes);
            log.info("User click on Profile Admin ");
        } catch (Exception e) {
            log.info("Unable to click on Profile Admin");
        }

    }

    public void enterCasesOptions(List<String> optionList) throws IOException {
        enterCasesOptionsList.clear();
        enterCasesOptionsList.addAll(optionList);
        for (String option : optionList) {
            try {
                if (option.equalsIgnoreCase("ER with Search")) {
                    if (enterCaseER.getAttribute("prevval") == null) {
                        BrowserUtilities.waitAndClickButton(enterCaseER);
                    }
                    BrowserUtilities.waitAndClickButton(enterCaseERInvPartyYes);
                } else if (option.equalsIgnoreCase("ER without Search")) {
                    if (enterCaseER.getAttribute("prevval") == null) {
                        BrowserUtilities.waitAndClickButton(enterCaseER);
                    }
                    BrowserUtilities.waitAndClickButton(enterCaseERInvPartyNo);
                } else if (option.equalsIgnoreCase("INV Intake Only")) {
                    if (enterCaseInv.getAttribute("prevval") == null) {
                        BrowserUtilities.waitAndClickButton(enterCaseInv);
                    }
                    BrowserUtilities.waitAndClickButton(enterCaseInvIntakeOnly);
                } else if (option.equalsIgnoreCase("INV Investigation Team")) {
                    if (enterCaseInv.getAttribute("prevval") == null) {
                        BrowserUtilities.waitAndClickButton(enterCaseInv);
                    }
                    BrowserUtilities.waitAndClickButton(enterCaseInvInvTeam);
                } else if (option.equalsIgnoreCase("INV Legal Advisor")) {
                    if (enterCaseInv.getAttribute("prevval") == null) {
                        BrowserUtilities.waitAndClickButton(enterCaseInv);
                    }
                    BrowserUtilities.waitAndClickButton(enterCaseInvLegalAdv);
                } else if (option.equalsIgnoreCase("ei")) {
                    if (enterCaseEI.getAttribute("prevval") == null) {
                        BrowserUtilities.waitAndClickButton(enterCaseEI);
                    }
                } else if (option.equalsIgnoreCase("ph")) {
                    if (enterCasePHInt.getAttribute("prevval") == null) {
                        BrowserUtilities.waitAndClickButton(enterCasePHInt);
                    }
                } else {
                    log.info("Invalid option - " + option);
                    Assert.fail("Invalid option - " + option);
                }

                log.info("User selects options from Enter Cases permission - " + option);
            } catch (Exception e) {
                log.info("User is not able to selects options from Enter Cases permission ");
            }
        }
    }

    public void verifyEnterCasePerms() throws IOException {

        try {
            String enterCasePerms = qvEnterCasePerms.getText();
            List<String> actualCasesOptionsList = Arrays.asList(enterCasePerms.split(", "));
            if (enterCasesOptionsList.size() == 4 && !enterCasesOptionsList.contains("without")) {
                if (enterCasePerms.equals("All")) {
                    log.info("Enter Case contains expected permission - " + enterCasePerms);
                }
            } else {
                if (enterCasesOptionsList.size() != actualCasesOptionsList.size()) {
                    log.info("Expected Enter Cases permissions - " + enterCasesOptionsList +
                            ", did not match with Actual Enter Cases permissions - " + actualCasesOptionsList);
                } else {
                    if (enterCasesOptionsList.containsAll(actualCasesOptionsList)) {
                        log.info("Expected Enter Cases permissions - " + enterCasesOptionsList +
                                ", matched with Actual Enter Cases permissions - " + actualCasesOptionsList);
                    } else {
                        log.info("Expected Enter Cases permissions - " + enterCasesOptionsList +
                                ", did not match with Actual Enter Cases permissions - " + actualCasesOptionsList);
                    }
                }
            }

        } catch (Exception e) {
            log.info("Unable to get Enter Cases permissions. " + e.getMessage());
            Assert.fail("Unable to get Enter Cases permissions. " + e.getMessage());
        }

    }

    public void cancelCaseEntryPermi() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(enterCaseCancel);
            log.info("User click on Cancel button");
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            log.info("Unable to click on cancel button. " + e.getMessage());
            Assert.fail("Unable to cancel Enter case permissions. " + e.getMessage());
        }
    }

    public void caseTypePermValidation(String role) throws IOException {
        List<String> actualCaseTypePerms = new ArrayList<>();
        if (role.equalsIgnoreCase("View Cases")) {
            String caseTypePerms = qvVcCaseTypePerms.getText();
            actualCaseTypePerms = Arrays.asList(caseTypePerms.split(", "));
            if (caseTypeOptionsList.containsAll(actualCaseTypePerms)) {
                log.info("Expected Case Type permissions - " + caseTypeOptionsList + ", matched with actual Case Type permissions - " + actualCaseTypePerms);
            } else {
                log.info("Expected Case Type permissions - " + caseTypeOptionsList + ", did not match with actual Case Type permissions - " + actualCaseTypePerms);
            }

        } else if (role.equalsIgnoreCase("Insights Reporting")) {
            String caseTypePerms = qvRptCaseTypeNonePerms.getText();
            actualCaseTypePerms = Arrays.asList(caseTypePerms.split(", "));
            if (rptCaseTypeOptionsList.containsAll(actualCaseTypePerms))
            //if(actualCaseTypePerms.containsAll(rptCaseTypeOptionsList))
            {
                log.info("Expected Case Type permissions - " + rptCaseTypeOptionsList + ", matched with actual Case Type permissions - " + actualCaseTypePerms);
            } else {
                log.info("Expected Case Type permissions - " + rptCaseTypeOptionsList + ", did not match with actual Case Type permissions - " + actualCaseTypePerms);
            }

        } else {
            log.info("Invalid role - " + role);
            Assert.fail("Invalid role - " + role);
        }
    }

    public void caseInsightsePermValidation(String role) throws IOException {
        List<String> actualCaseTypePerms = new ArrayList<>();
        if (role.equalsIgnoreCase("Insights Reporting")) {
            String caseTypePerms = qvRptInsightsCaseTypePerms.getText();
            actualCaseTypePerms = Arrays.asList(caseTypePerms.split(", "));
            if (rptCaseInsightsOptionsList.containsAll(actualCaseTypePerms)) {
                log.info("Expected Insights permissions - " + rptCaseInsightsOptionsList + ", matched with actual Insights permissions - " + actualCaseTypePerms);
            } else {
                log.info("Expected Insights permissions - " + rptCaseInsightsOptionsList + ", did not match with actual Insights permissions - " + actualCaseTypePerms);
            }

        } else {
            log.info("Invalid role - " + role);
            Assert.fail("Invalid role - " + role);
        }
    }

    public void enableInsightsRpt() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(rptAccessYes);
            log.info("User enables Insights Reporting Role sucessfully ");
        } catch (Exception e) {
            log.info("User is not able to Insights Reporting Role ");
        }


    }

    public void instRptLmtNEditDetails(String accessType) throws IOException {

        try {
            if (accessType.contains("Case type")) {
                BrowserUtilities.waitAndClickButton(rptCaseTypeLmt);
                BrowserUtilities.waitAndClickButton(rptCaseTypeLmtViewDetail);
            } else if (accessType.contains("Group access")) {
                BrowserUtilities.waitAndClickButton(rptGrpAccessLmt);
                BrowserUtilities.waitAndClickButton(rptGrpAccessViewDet);
            } else if (accessType.contains("Issue access")) {
                BrowserUtilities.waitAndClickButton(rptIssueAccessLmt);
                BrowserUtilities.waitAndClickButton(rptIssueAccessViewDet);
            } else if (accessType.contains("Location access")) {
                BrowserUtilities.waitAndClickButton(rptLocAccessLmt);
                BrowserUtilities.waitAndClickButton(rptLocAccessViewDet);
            } else {
                log.info("Invalid access type " + accessType);
                Assert.fail("Invalid access type " + accessType);
            }
            log.info(
                    "User selects option view cases " + accessType + " and Edit details");
        } catch (Exception e) {
            log.info("User is not able to select option view cases " + accessType + " and Edit details");
        }

    }

    public void rptCaseTypeOptions(List<String> optionList) throws IOException {
        rptCaseTypeOptionsList.clear();
        rptCaseTypeOptionsList.addAll(optionList);
        resetRptCaseTypeOptions();
        for (String option : optionList) {
            try {
                if (option.equalsIgnoreCase("er")) {
                    BrowserUtilities.waitAndClickButton(rptCaseTypeER);
                } else if (option.equalsIgnoreCase("inv")) {
                    BrowserUtilities.waitAndClickButton(rptCaseTypeINV);
                } else if (option.equalsIgnoreCase("ei")) {
                    BrowserUtilities.waitAndClickButton(rptCaseTypeEI);
                } else if (option.equalsIgnoreCase("ph")) {
                    BrowserUtilities.waitAndClickButton(rptCaseTypePH);
                } else {
                    log.info("Invalid option - " + option);
                    Assert.fail("Invalid option - " + option);
                }

                log.info("User selects options from Case Type permission - " + option);
            } catch (Exception e) {
                log.info("User is not able to selects options from Case Type permission ");
            }
        }
    }

    private void resetRptCaseTypeOptions() throws IOException {
        try {
            if (rptCaseTypeER.getAttribute("prevval") != null) {
                BrowserUtilities.waitAndClickButton(rptCaseTypeER);
            }

            if (rptCaseTypeINV.getAttribute("prevval") != null) {
                BrowserUtilities.waitAndClickButton(rptCaseTypeINV);
            }
            if (rptCaseTypeEI.getAttribute("prevval") != null) {
                BrowserUtilities.waitAndClickButton(rptCaseTypeEI);
            }

            if (rptCaseTypePH.getAttribute("prevval") != null) {
                BrowserUtilities.waitAndClickButton(rptCaseTypePH);
            }

        } catch (Exception e) {
            log.info(e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

    public void caseInsightsOptions(List<String> optionList) throws IOException {
        rptCaseInsightsOptionsList.clear();
        rptCaseInsightsOptionsList.addAll(optionList);
        //resetVcCaseTypeOptions();
        for (String option : optionList) {
            try {
                if (option.equalsIgnoreCase("Insights Analytics")) {
                    BrowserUtilities.waitAndClickButton(rptInsightAnltsYes);
                } else if (option.equalsIgnoreCase("Involved Party Reports")) {
                    BrowserUtilities.waitAndClickButton(rptInvPrtDtlsYes);
                } else if (option.equalsIgnoreCase("Custom Profile Fields")) {
                    BrowserUtilities.waitAndClickButton(rptCusProFldsYes);
                } else if (option.equalsIgnoreCase("Insights Dashboard")) {
                    BrowserUtilities.waitAndClickButton(rptInsightDBYes);
                } else if (option.equalsIgnoreCase("Insights Benchmark")) {
                    BrowserUtilities.waitAndClickButton(rptInsightBMYes);
                    BrowserUtilities.waitAndClickButton(OK);
                    TimeUnit.SECONDS.sleep(1);
                } else if (option.equalsIgnoreCase("Event Based Insights")) {
                    BrowserUtilities.waitAndClickButton(rptEvntBsdInstYes);
                } else {
                    log.info("Invalid option - " + option);
                    Assert.fail("Invalid option - " + option);
                }

                log.info("User selects options from Insights Reporting  permission - " + option);
            } catch (Exception e) {
                log.info("User is not able to selects options from Insights Reporting permission ");
            }
        }
    }

    public void saveRptPermission(String caseType) throws IOException {
        try {
            if (caseType.equalsIgnoreCase("Case Type")) {
                BrowserUtilities.waitAndClickButton(rptCaseTypeSave);
            } else if (caseType.equalsIgnoreCase("Group access")) {
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(rptGrpSave);
            } else if (caseType.equalsIgnoreCase("Issue access")) {
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(rptIssuesSave);
            } else if (caseType.equalsIgnoreCase("Location access")) {
//				click(rptLocSave);
//				click(rptLocAccessViewDet);
//				irLocationsList.clear();
//				List<WebElement> we = driver.findElements(By.xpath(RbacOR.rptLocSelected));
//				for(WebElement e : we){
//					irLocationsList.add(e.getText().trim());
//				}
                TimeUnit.SECONDS.sleep(2);
                BrowserUtilities.waitAndClickButton(rptLocSave);
            }
            log.info("User saved the " + caseType + "permissions");
        } catch (Exception e) {
            log.info("User is not able to save the " + caseType + "permissions");
        }

    }

    public void enableMnrgCaseApprover() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(isMngrCaseApproverYes);
            log.info("User enable Manager case Approver successfully ");
        } catch (Exception e) {
            log.info("User is not able to enable Manager case Approver ");
        }
    }

    public void enableLegalHoldAdmin() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(isLegalHoldAdminYes);
            log.info("User enables Legal Hold Admin Role sucessfully ");
        } catch (Exception e) {
            log.info("User is not able enable Legal Hold Admin Role ");
        }

    }

    public void enableAuditLogAdmin() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(isAuditLogAdminYes);
            log.info("User enables Audit Log Admin Role sucessfully ");
        } catch (Exception e) {
            log.info("User is not able enable Audit Log Admin Role ");
        }

    }

    public void enableHomePageTrendingAnalytics() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(isenableHomePageTrendingAnalyticsYes);
            log.info("User enables Data Integration Admin Role sucessfully ");
        } catch (Exception e) {
            log.info("User is not able enable Data Integration Admin Role ");
        }

    }

    public void enableDataShredder() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(isDataShredderYes);
            BrowserUtilities.waitAndClickButton(ShredOK);
            log.info("User enables Data Data Shredder Role sucessfully ");
        } catch (Exception e) {
            log.info("User is not able enable Data Shredder Role ");
        }

    }

    public void enableOtherConfigAdmin() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(isConfigAdminYes);
            log.info("User enable Configuration Admin successfully ");
        } catch (Exception e) {
            log.info("User is not able to enable Configuration Admin ");
        }
    }

    public void verifyOtherPerms(String role) throws IOException {
        String actualOtherPerms = qvOtherPerms.getText();
        if (actualOtherPerms.contains(role)) {
            log.info("Actual Other Permissions - " + actualOtherPerms + " contain expected permission - " + role);
        } else {
            log.info("Actual Other Permissions - " + actualOtherPerms + " does not contain expected permission - " + role);
        }
    }


    //User Specific Permission Assign Role......//
    public void assignUserToRole() throws IOException {
        try {
            BrowserUtilities.waitAndClickButton(quickviewUser);
            BrowserUtilities.waitAndClickButton(editAssignment);
            BrowserUtilities.waitAndClickButton(enterRole);
            BrowserUtilities.sendInputKeys(enterRole, "Roles");
            TimeUnit.SECONDS.sleep(3);
            enterRole.sendKeys(Keys.ARROW_DOWN);
            enterRole.sendKeys(Keys.ENTER);
            BrowserUtilities.waitAndClickButton(assignToRole);
            BrowserUtilities.waitAndClickButton(assignYesButton);
            TimeUnit.SECONDS.sleep(1);
            log.info("User assign Role to User successfully ");
        } catch (Exception e) {
            log.info("User is not able to assign Role to User ");
        }
    }


    public void loginAssignedUser() throws InterruptedException, IOException {
        String key = "qa";
        String path = "src/test/resources/properties/qa/LoginPage.properties";
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(path);
        prop.load(input);
        String userName = prop.getProperty("assignedUserEmail");
        String password = prop.getProperty("assignedUserPassword");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.email().clear();
        loginPage.email().sendKeys(userName);
        Thread.sleep(1000);
        loginPage.password().clear();
        loginPage.password().sendKeys(password);
        Thread.sleep(1000);
        loginPage.login().click();
        loginPage.iAgree().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        Thread.sleep(4000);
        System.out.println(loginPage.name().getText());
        log.info("Login test passed, logged by " + loginPage.name().getText());
        Thread.sleep(4000);
    }

    ////Enter Case Role Permission Validation.........////
    public void checkUserCaseEnterPermission(String newRole) throws InterruptedException, IOException {
        BrowserUtilities.waitAndClickButton(AllCases);
        Thread.sleep(1000);
        List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class=\"c-nav__menuChildLink\"]//a"));
        List<String> actualOptions = new ArrayList<String>();
        List<String> expectedOptions = new ArrayList<String>();
        for (WebElement webElement : allOptions) {
            actualOptions.add(webElement.getText());
        }
        System.out.println("Actual options are" + actualOptions);

        if (newRole.equalsIgnoreCase("All permission")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Document Issue/Event", "Conduct Investigation", "Post-Hire Interview", "Exit Interview"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            System.out.println("My boolean is" + isEqual);
            if (isEqual == true) {

                log.info("User with All Permissions - " + actualOptions + " having expected permissions - " + expectedOptions);
            } else
                log.info("User with All Permissions - " + actualOptions + "do not having expected permissions - " + expectedOptions);
        }

        if (newRole.equalsIgnoreCase("ER,INV Permission")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Document Issue/Event", "Conduct Investigation"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            System.out.println("My boolean is" + isEqual);
            if (isEqual == true) {

                log.info("User with ER,INV Permissions - " + actualOptions + " having expected permissions - " + expectedOptions);
            } else
                log.info("User with ER,INV Permissions - " + actualOptions + "do not having expected permissions - " + expectedOptions);
        }

        if (newRole.equalsIgnoreCase("ER,PH Permission")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Document Issue/Event", "Post-Hire Interview"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            System.out.println("My boolean is" + isEqual);
            if (isEqual == true) {

                log.info("User with ER,PH Permissions - " + actualOptions + " having expected permissions - " + expectedOptions);
            } else
                log.info("User with ER,PH Permissions - " + actualOptions + "do not having expected permissions - " + expectedOptions);
        }

        if (newRole.equalsIgnoreCase("INV,EI,PH Permission")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Conduct Investigation", "Post-Hire Interview", "Exit Interview"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            System.out.println("My boolean is" + isEqual);
            if (isEqual == true) {

                log.info("User with INV,EI,PH Permissions - " + actualOptions + " having expected permissions - " + expectedOptions);
            } else
                log.info("User with INV,EI,PH Permissions - " + actualOptions + "do not having expected permissions - " + expectedOptions);
        }
    }

    public void checkUserINVPermission(String newRole) throws InterruptedException, IOException {
        List<WebElement> allOptions = driver.findElements(By.xpath("(//*[@class=\"c-content__table jq-casegrid\"]//tbody//tr/td)[6]"));
        List<String> actualOptions = new ArrayList<String>();
        List<String> expectedOptions = new ArrayList<String>();
        for (WebElement webElement : allOptions) {
            actualOptions.add(webElement.getText());
        }
        System.out.println("Actual options are" + actualOptions);

        if (newRole.equalsIgnoreCase("INV Investigation Permission")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Lead Investigator"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            System.out.println("My boolean is" + isEqual);
            if (isEqual == true) {

                log.info("User with INV Investigation Permissions - " + actualOptions + " having expected permissions - " + expectedOptions);
            } else
                log.info("User with INV Investigation Permissions - " + actualOptions + "do not having expected permissions - " + expectedOptions);
        }

        if (newRole.equalsIgnoreCase("INV Intake Only Permission")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Intake Only"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            System.out.println("My boolean is" + isEqual);
            if (isEqual == true) {

                log.info("User with INV Intake Only Permissions - " + actualOptions + " having expected permissions - " + expectedOptions);
            } else
                log.info("User with INV Intake Only Permissions - " + actualOptions + "do not having expected permissions - " + expectedOptions);
        }
    }

    public void checkUserINVLegalAdvisorPermission(String newRole) throws InterruptedException, IOException {
        Thread.sleep(1000);
        List<WebElement> allOptions = driver.findElements(By.xpath("(//*[@class=\"c-content__table jq-casegrid\"]//tbody//tr/td)[14]"));
        List<String> actualOptions = new ArrayList<String>();
        List<String> expectedOptions = new ArrayList<String>();
        for (WebElement webElement : allOptions) {
            actualOptions.add(webElement.getText());
        }
        System.out.println("Actual options are" + actualOptions);

        if (newRole.equalsIgnoreCase("INV Legal Advisor")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Legal Advisor"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            System.out.println("My boolean is" + isEqual);
            if (isEqual == true) {

                log.info("User with INV Legal Advisor Permissions - " + actualOptions + " having expected permissions - " + expectedOptions);
            } else
                log.info("User with INV Legal Advisor Permissions - " + actualOptions + "do not having expected permissions - " + expectedOptions);
        }
        Thread.sleep(1000);
    }

    ////Other Role Permissions Validation.........////
    public void checkUserOtherPermission(String newRole) throws InterruptedException, IOException {
        BrowserUtilities.waitAndClickButton(Administration);
        Thread.sleep(1000);
        List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id=\"liadmin\"]/ul/li/a"));
        List<String> actualOptions = new ArrayList<String>();
        List<String> expectedOptions = new ArrayList<String>();

        for (WebElement webElement : allOptions) {
            actualOptions.add(webElement.getText());
        }

        System.out.println("Actual options are" + actualOptions);

        if (newRole.equalsIgnoreCase("Others permission")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Data Upload", "Document Library", "EI and PH Fields", "ER and INV Fields", "Feature Configuration", "Groups and Locations", "Legal Hold", "managER Configuration", "Shredding Data", "Templates", "Audit Log"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            System.out.println("My boolean is" + isEqual);
            if (isEqual == true) {

                log.info("User with Other Permissions - " + actualOptions + " having expected permissions - " + expectedOptions);
            } else
                log.info("User with Other Permissions - " + actualOptions + "do not having expected permissions - " + expectedOptions);
        }
    }

    ////Profile Admin Role Permissions Validation.........////
    public void checkUserProfileAdminPermission(String newRole) throws InterruptedException, IOException {
        BrowserUtilities.waitAndClickButton(Administration);
        Thread.sleep(1000);
        List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id=\"liadmin\"]/ul/li/a"));
        List<String> actualOptions = new ArrayList<String>();
        List<String> expectedOptions = new ArrayList<String>();

        for (WebElement webElement : allOptions) {
            actualOptions.add(webElement.getText());
        }

        System.out.println("Actual options are" + actualOptions);

        if (newRole.equalsIgnoreCase("Profile Admin")) {

            expectedOptions = new ArrayList<>(Arrays.asList("Feature Configuration", "Roles and Permissions"));
            System.out.println("Expected options are" + expectedOptions);
            boolean isEqual = actualOptions.equals(expectedOptions);
            System.out.println("My boolean is" + isEqual);
            if (isEqual == true) {

                log.info("User with Profile Admin Permissions - " + actualOptions + " having expected permissions - " + expectedOptions);
            } else
                log.info("User with Profile Admin Permissions - " + actualOptions + "do not having expected permissions - " + expectedOptions);
        }
    }

}
